(ns project-euler.problem-036
  (:require [project-euler.utils :refer [palindromic?]]))

(defn to-n [digits]
  (reduce + (map * (reverse digits) (iterate #(*' 10 %) 1))))

(defn dec-to-bin [x]
  (to-n (loop [n x, b ()]
          (if (zero? n) b (recur (quot n 2) (cons (rem n 2) b))))))

(defn dec-bin-palindromic? [x]
  (and (palindromic? x)
       (palindromic? (dec-to-bin x))))

(defn solution-036 []
  (reduce + (filter dec-bin-palindromic? (range 1000000))))
