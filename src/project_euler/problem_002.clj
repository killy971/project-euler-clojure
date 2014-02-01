(ns project-euler.problem-002
  (:require [project-euler.utils :refer [fib-seq]]))

(defn sum-even-fib [max]
  (reduce + (filter odd? (take-while #(< % max) fib-seq))))

(defn solution-002 []
  (sum-even-fib 4000000))
