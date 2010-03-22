(ns net.projecteuler.128
  (:use [clojure.set :only [union]]))

(defstruct h-tile :value :prevs :neighbors)

(def ring-seq
  ((fn ring [integers, n]
     (lazy-seq
       (cons 
         (take
           (* 6 n)
           (map
             #(struct-map h-tile :value %1 :prevs %2)
             integers
             (map
               #(if (zero? (mod % n)) 1 2)
               (iterate inc 0))))
         (ring (drop (* 6 n) integers) (inc n)))))
     (iterate inc 2) 1))

(defn set-ring-neighbors [ring]
  (map
    #(assoc %1 :neighbors (sorted-set (first %2) (last %2))) ring
    (let [values (map :value ring)]
      (partition
        3 1 (take
              (+ 2 (count values))
              (drop (dec (count values)) (cycle values)))))))

(defn set-inside-neighbors [in-ring, out-ring]
  (let [out-r (cons (last out-ring) out-ring)]
    (loop [out-h (first out-ring),
           out-t (rest out-ring),
           n-list (list (sorted-set))]
      (if (empty? out-t)
        ()
        ()

(defn set-outside-neighbors [in-ring, out-ring]
  (loop
    [r (set-ring-neighbors out-ring),
     prev-values (cycle (map :value in-ring)),
     result []]
    (if (empty? r) (seq result)
      (let [fst-r (first r)
            prevs (:prevs fst-r)
            nbors (:neighbors fst-r)]
        (recur
          (rest r)
          (drop (dec prevs) prev-values)
          (conj
            result
            (assoc
               fst-r :neighbors (union nbors (apply sorted-set (take prevs prev-values))))))))))

(def h-tile-seq
  ((fn tiles [fst-r snd-r r-seq]
     (lazy-seq
       (cons
         (set-outside-neighbors prev-r (first r-seq))
         (tiles (first r-seq) (rest r-seq))))
     ) (list (struct-map h-tile :value 1)) ring-seq))
