(ns project-euler.problem-055
  (:require [project-euler.utils :refer [palindromic? to-d]]))

(defn rev-int [x]
  (reduce +' (map * (to-d x) (iterate #(*' 10 %) 1))))

(defn lychrel? [x]
  (loop [n x, i 50]
    (let [next (+' n (rev-int n))]
      (cond
        (zero? i) true
        (palindromic? next) false
        :default (recur next (dec i))))))

(defn solution-055 []
  (count (filter lychrel? (range 10000))))
