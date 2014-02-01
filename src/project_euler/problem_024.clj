(ns project-euler.problem-024
  (:require [clojure.math.combinatorics :refer [permutations]]))

(defn nth-permutation [n]
  (nth (permutations (range 10)) (dec n)))

(defn solution-024 []
  (reduce str (nth-permutation 1000000)))
