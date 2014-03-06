(ns project-euler.problem-036
  (:require [project-euler.utils :refer [palindromic?]]))

(defn to-n [digits]
  (reduce + (map * (reverse digits) (iterate #(*' 10 %) 1))))

(defn dec-to-bin [x] (new java.math.BigInteger (Integer/toString x 2)))

(defn dec-bin-palindromic? [x]
  (and (palindromic? x)
       (palindromic? (dec-to-bin x))))

(defn solution-036 []
  (reduce + (filter dec-bin-palindromic? (range 1000000))))
