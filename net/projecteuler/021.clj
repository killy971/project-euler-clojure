(ns net.projecteuler.021)

(defn proper-divisors-sum [n]
  (reduce + (filter #(zero? (rem n %)) (range 1 (inc (quot n 2))))))

(def proper-divisors-sum-m (memoize proper-divisors-sum))

(defn amical-number [a]
  (let [b (proper-divisors-sum-m a)]
    (and (not= a b) (= a (proper-divisors-sum-m b)))))

(defn problem-021 []
  (reduce + (filter amical-number (range 10000))))
