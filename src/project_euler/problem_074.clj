(ns project-euler.problem-074
  (:require [project-euler.utils :refer [fact caseify]]))

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

(defn solution-074 []
  (count (filter #(= (chain-length %) 60) (range 1000000))))
