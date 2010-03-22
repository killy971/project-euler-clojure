(ns net.projecteuler.087
  (:use [net.projecteuler.utils :only [sieve]]))

(defn for-p [primes, max-n, p-sum, array, pow-f, next-f]
  (loop [p (first primes), p-seq (rest primes)]
    (let [sum (+ p-sum (pow-f p))]
      (cond
        (> sum max-n) array
        (empty? p-seq) (next-f sum array)
        :default (do (next-f sum array) (recur (first p-seq) (rest p-seq)))))))

(defn for-c [primes, max-n, p-sum, array]
  (for-p primes max-n p-sum array #(* % (* % (* % %)))
         (fn [sum, arr] (do (aset-int arr sum 1) arr))))

(defn for-b [primes, max-n, p-sum, array]
  (for-p primes max-n p-sum array #(* % (* % %))
         (fn [sum, arr] (for-c primes max-n sum arr))))

(defn for-a [primes, max-n, p-sum, array]
  (for-p primes max-n p-sum array #(* % %)
         (fn [sum, arr] (for-b primes max-n sum arr))))

(defn fill-array [max-n]
  (let [array (int-array max-n)
        primes (sieve (Math/sqrt (- max-n (* 2 2) (* 2 2 2))))]
    (for-a primes max-n 0 array)))

(defn problem-087 []
  (reduce + (fill-array 5e7)))
