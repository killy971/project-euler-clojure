(set! *warn-on-reflection* true)

(load-file "sieve.clj")
(load-file "utils.clj")

(def primes-seq (sieve 10000000))

(defn permute [l]
  (concat (rest l) (take 1 l)))

(defn is-permutation [x y]
  (let [d-list (to-d x)]
    (loop [i (dec (count d-list)), next-permutation (permute d-list)]
      (cond
        (zero? i) false
        (= y (to-n next-permutation)) true
        :default (recur (dec i) (permute next-permutation))))))

(defn min-ratio [max-n]
  (loop [n 11, n-for-min 87109, min-r (/ 87109 79180)]
    (let [phi-n (phi primes-seq n) r (/ n phi-n)]
      (cond
        (= n max-n) n-for-min
        (and (< r min-r) (is-permutation n phi-n)) (recur (inc n) n r)
        :default (recur (inc n) n-for-min min-r)))))

(println (min-ratio 10000000))
