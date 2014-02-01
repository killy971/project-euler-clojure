(ns project-euler.problem-034
  (:require [project-euler.utils :refer [fact to-d]]))

(def fact-m (memoize fact))

(defn eq-sum-of-fact [n]
  (and (> n 9)
       (= n (reduce + (map fact-m (to-d n))))))

(defn solution-034 []
  (reduce + (filter eq-sum-of-fact (range 100000))))
