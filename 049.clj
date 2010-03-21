(use 'de.tsdh.math.primes)

(load-file "sieve.clj")

(def sieve-primes
  (drop-while #(< % 1234) (sieve 3216)))

(defn to-n [digits]
  (reduce + (map * (reverse digits) (iterate #(* 10 %) 1))))

(defn to-d [number]
  (loop [n number, digit-seq []]
    (if (< n 10)
      (cons n digit-seq)
        (recur (quot n 10) (cons (rem n 10) digit-seq)))))

(defn is-perm? [digits n]
  (= (sort digits) (sort (to-d n))))

(defn problem-49 [p-seq]
  (loop [n (first p-seq), p-seq (rest p-seq)]
    (let [digits (to-d n)
          n-1 (+ n 3330)
          n-2 (+ n 6660)]
      (if (and
            (is-perm? digits n-1)
            (prime? n-1)
            (is-perm? digits n-2)
            (prime? n-2)
            (not= n 1487))
        (to-n (concat (to-d n) (to-d n-1) (to-d n-2)))
        (recur (first p-seq) (rest p-seq))))))

(println (problem-49 sieve-primes))
