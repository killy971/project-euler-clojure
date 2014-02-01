(ns project-euler.problem-072
  (:require [project-euler.utils :refer [phi sieve]]))

(def primes-seq (sieve 1000000))

(defn local-phi [x]
  (phi primes-seq x))

(defn solution-072 []
  (reduce + (map local-phi (range 2 1000001))))
