(ns net.projecteuler.072
  (:use [net.projecteuler.utils :only [phi sieve]]))

(def primes-seq (sieve 1000000))

(defn local-phi [x]
  (phi primes-seq x))

(defn problem-072 []
  (reduce + (map local-phi (range 2 1000001))))
