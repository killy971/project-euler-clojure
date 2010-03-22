(ns net.projecteuler.034
  (:use [net.projecteuler.utils :only [fact to-d]]))

(def fact-m (memoize fact))

(defn eq-sum-of-fact [n]
  (and (> n 9)
       (= n (reduce + (map fact-m (to-d n))))))

(defn problem-034 []
  (reduce + (filter eq-sum-of-fact (range 100000))))
