(ns net.projecteuler.041
  (:use [net.projecteuler.utils :only [pandigital? sieve]]))

(defn problem-041 []
  (last (filter pandigital? (sieve 7654321))))

; cannot try with numbers containing 8 or 9, because they can't be prime
