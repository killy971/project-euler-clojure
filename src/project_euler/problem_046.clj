(ns project-euler.problem-046
  (:require [project-euler.utils :refer [sieve]]))

(defn composite-odds [n]
  (loop [i 1, composite-odd-list (), primes (sieve n)]
    (if (empty? primes)
      (rest (reverse composite-odd-list))
      (let [next-prime (first primes)
            is-i-prime (= i next-prime)]
        (recur (inc i)
               (if (and (odd? i) (not is-i-prime))
                 (cons i composite-odd-list)
                 composite-odd-list)
               (if is-i-prime
                 (rest primes)
                 primes))))))

(defn written-as-sum-of-prime-and-twice-square? [x]
  (let [twc-sqr-list (take-while #(< % x) (map #(* 2 % %) (iterate inc 1)))
        remdrs (map #(- x %) twc-sqr-list)
        primes (reverse (sieve x))]
    (loop [remdr (first remdrs), r-list (rest remdrs),
           prime (first primes), p-list (rest primes)]
      (let [cmp (compare remdr prime)]
        (cond
          (= 0 cmp) true
          (and (empty? p-list) (empty? r-list)) false
          (= 1 cmp) (if (empty? r-list) false
                      (recur (first r-list) (rest r-list) prime p-list))
          :default (if (empty? p-list) false
                     (recur remdr r-list (first p-list) (rest p-list))))))))

(defn solution-046 []
  (first (filter #(not (written-as-sum-of-prime-and-twice-square? %))
                 (composite-odds 10000))))
