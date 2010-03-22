(ns net.projecteuler.049
  (:use
     [de.tsdh.math.primes :only [prime?]]
     [net.projecteuler.utils :only [sieve to-d to-n]]))

(defn is-perm? [digits n]
  (= (sort digits) (sort (to-d n))))

(defn problem-049 []
  (let [p-seq (drop-while #(< % 1234) (sieve 3216))]
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
          (recur (first p-seq) (rest p-seq)))))))
