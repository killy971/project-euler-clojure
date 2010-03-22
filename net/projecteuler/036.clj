(ns net.projecteuler.036
  (:use [net.projecteuler.utils :only [palindromic? to-n]]))

(defn dec-to-bin [x]
  (to-n (loop [n x, b ()]
          (if (zero? n) b (recur (quot n 2) (cons (rem n 2) b))))))

(defn dec-bin-palindromic? [x]
  (and (palindromic? x)
       (palindromic? (dec-to-bin x))))

(defn problem-036 []
  (reduce + (filter dec-bin-palindromic? (range 1000000))))
