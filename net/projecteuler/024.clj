(ns net.projecteuler.024
  (:use [clojure.contrib.combinatorics :only [permutations]]))

(defn nth-permutation [n]
  (nth (permutations (range 10)) (dec n)))

(defn problem-024 []
  (reduce str (nth-permutation 1000000)))
