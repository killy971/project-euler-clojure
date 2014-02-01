(ns project-euler.problem-041
  (:require [project-euler.utils :refer [pandigital? sieve]]))

(defn solution-041 []
  (last (filter pandigital? (sieve 7654321))))

; cannot try with numbers containing 8 or 9, because they can't be prime
