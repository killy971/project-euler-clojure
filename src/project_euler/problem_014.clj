(ns project-euler.problem-014
  (:require [project-euler.utils :refer [index-of]]))

(defn index-of-max [coll]
  (index-of > coll))

(defn collatz-length [^long x]
  (loop [n x, length 2]
    (if (= 1 n)
      length
      (recur (if (odd? n) (inc (* 3 n)) (quot n 2)) (inc length)))))

(defn max-collatz-length-starting-number [limit]
  (inc (index-of-max (map collatz-length (range 1 limit)))))

(defn solution-014 []
  (max-collatz-length-starting-number 1000000))
