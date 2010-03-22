(ns net.projecteuler.002
  (:use [net.projecteuler.utils :only [fib-seq]]))

(defn sum-even-fib [max]
  (reduce + (filter odd? (take-while #(< % max) fib-seq))))

(defn problem-002 []
  (sum-even-fib 4000000))
