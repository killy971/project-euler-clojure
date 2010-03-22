(ns net.projecteuler.052
  (:use [net.projecteuler.utils :only [to-d]]))

(defn same-digits [x]
  (let [d-lists (map #(sort (to-d %))
                     (map #(* % x) (range 2 7)))]
    (every? #(= (first d-lists) %)
            (rest d-lists))))

(defn problem-052 []
  (first (filter same-digits (iterate inc 1))))
