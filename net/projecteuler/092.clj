(ns net.projecteuler.092
  (:use [net.projecteuler.utils :only [to-d]]))

(defn ends-by [n]
  (loop [i n]
    (let [next (reduce + (map #(* % %) (to-d i)))]
      (cond
        (= next 1) 0
        (= next 89) 1
        :default (recur next)))))

(defn problem-092 []
  (reduce + (map ends-by (range 1 10000000))))
