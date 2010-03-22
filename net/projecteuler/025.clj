(ns net.projecteuler.025
  (:use [net.projecteuler.utils :only [fib-seq]]))

(defn problem-025 []
  (ffirst
    (filter #(= (count (str (second %))) 1000)
            (map vector (iterate inc 1) fib-seq))))
