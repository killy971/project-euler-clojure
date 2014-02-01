(ns project-euler.problem-052
  (:require [project-euler.utils :refer [to-d]]))

(defn same-digits [x]
  (let [d-lists (map #(sort (to-d %))
                     (map #(* % x) (range 2 7)))]
    (every? #(= (first d-lists) %)
            (rest d-lists))))

(defn solution-052 []
  (first (filter same-digits (iterate inc 1))))
