(ns net.projecteuler.074
  (:use [net.projecteuler.utils :only [fact caseify]]))

(def digit-fact (caseify fact 10))

(defn digits-fact [number]
  (loop [n number, res 0]
    (if (< n 10)
      (+ (digit-fact n) res)
      (recur (quot n 10) (+ (fact (rem n 10)) res)))))

(defn chain-length [start]
  (loop [n start, chain #{}]
    (if (contains? chain n)
      (count chain)
      (recur (digits-fact n) (conj chain n)))))

(defn problem-074 []
  (count (filter #(= (chain-length %) 60) (range 1000000))))
