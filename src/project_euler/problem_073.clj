(ns project-euler.problem-073
  (:require [clojure.math.numeric-tower :refer [gcd]]))

(defn start-num [d]
  (let [n (quot d 3)]
    (if (> (/ n d) (/ 3)) n (inc n))))

(defn end-num [d]
  (let [n (quot d 2)]
    (if (< (/ n d) (/ 2)) n (dec n))))

(defn count-for-den [d]
  (let [end-n (end-num d)]
    (loop [n (start-num d), cnt 0]
      (if (> n end-n)
        cnt
        (recur (inc n) (if (= 1 (gcd d n)) (inc cnt) cnt))))))

(defn count-until-den [max-den]
  (reduce + (map count-for-den (range 4 (inc max-den)))))

(defn solution-073 []
  (count-until-den 10000))
