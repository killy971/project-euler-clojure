(ns project-euler.problem-025
  (:require [project-euler.utils :refer [fib-seq]]))

(defn solution-025 []
  (ffirst
    (filter #(= (count (str (second %))) 1000)
            (map vector (iterate inc 1) fib-seq))))
