; Calculate the sum of all the primes below two million.

(ns net.projecteuler.010
  (:use [net.projecteuler.utils :only [sieve]]))

(defn problem-010 []
  (reduce + (sieve 2000000)))
