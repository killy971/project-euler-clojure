(ns project-euler.problem-032
  (:require [project-euler.utils :refer [to-n]]
            [clojure.math.combinatorics :refer [permutations]]))

(defn has-p? [mult-d prod]
  (let [m1 (to-n (take 1 mult-d)) m4 (to-n (drop 1 mult-d))
        m2 (to-n (take 2 mult-d)) m3 (to-n (drop 2 mult-d))]
    (or (= (* m1 m4) prod) (= (* m2 m3) prod))))

(defn pand-prods []
  (reduce
    (fn [prods digits]
      (let [mult-d (take 5 digits)
            prod (to-n (drop 5 digits))]
        (if (has-p? mult-d prod) (conj prods prod) prods)))
    (set [])
    (permutations (range 1 10))))

(defn solution-032 []
  (reduce + (pand-prods)))
