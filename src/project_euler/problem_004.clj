(ns project-euler.problem-004
  (:require [project-euler.utils :refer [palindromic?]]))

(defn solution-004
  "Returns the largest palindrome made from the product of two 3-digit numbers"
  []
  (apply max (filter palindromic? (for [x (range 100 999) y (range 100 999) :when (>= y x)] (* x y)))))
