(load-file "sieve.clj")
(load-file "utils.clj")

(def primes-seq (sieve 1000000))

(defn local-phi [x]
  (phi primes-seq x))

(println (reduce + (map local-phi (range 2 1000001))))
