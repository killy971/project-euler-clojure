; Calculate the sum of all the primes below two million.

(ns project-euler.problem-010
  (:require [project-euler.utils :refer [sieve]]))

(defn solution-010 []
  (reduce + (sieve 2000000)))
