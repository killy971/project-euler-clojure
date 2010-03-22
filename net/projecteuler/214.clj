(ns net.projecteuler.214
  (:use [net.projecteuler.utils :only [phi sieve]]))

(def phi-m (memoize phi))

(defn update-chain-length [p-seq, lengths, n]
  (if (= 2 n) lengths
    (loop [p (dec n), i 1]
      (if (contains? lengths p)
        (assoc lengths n (+ i (get lengths p)))
        (recur (phi-m p-seq p) (inc i))))))

(defn make-chain-lengths [p-seq]
  (reduce #(update-chain-length p-seq %1 %2) (hash-map 1 1 2 2) p-seq))

(defn problem-214 []
  (let [chain-lengths (make-chain-lengths (sieve 4e7))]
    (reduce #(+ %1 (key %2)) 0 (filter #(= 25 (val %)) chain-lengths))))
