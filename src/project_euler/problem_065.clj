(ns project-euler.problem-065
  (:require [project-euler.utils :refer [to-d]]))

(def e-seq
  (map #(if (zero? (rem % 3)) (* 2 (/ % 3)) 1) (iterate inc 2)))

(defn e-frac [n]
  (let [c-seq (reverse (take (dec n) e-seq))]
    (+ 2 (reduce #(/ (+ %1 %2)) 0 c-seq))))

(defn solution-065 []
  (reduce + (to-d (numerator (e-frac 100)))))
