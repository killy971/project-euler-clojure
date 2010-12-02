(ns net.projecteuler.014
  (:use [net.projecteuler.utils :only [index-of]]))

(defn the-length [x]
  (loop [n x, length (inc 1)]
    (if (= 1 n)
      length
      (recur (if (odd? n) (inc (* 3 n)) (quot n 2)) (inc length)))))

(defn problem-014 []
  (inc (index-of > (map the-length (range 1 1000000)))))
