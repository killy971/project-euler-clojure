(ns net.projecteuler.050
  (:use [net.projecteuler.utils :only [sieve]]))

(def sieve-primes (sieve 4000))

(defn test-p-seq [p-index p-count]
  (let [p-seq (take p-count (drop p-index sieve-primes)), sum (reduce + p-seq)]
    (cond
      (> sum 1000000) -1
      (prime? sum) sum
      :default 0)))

(defn start-length [primes-seq]
  (loop [i 0, n 0, p-seq primes-seq]
    (if (> n 1000000) i (recur (inc i) (+ n (first p-seq)) (rest p-seq)))))

(loop [index 0, length (start-length sieve-primes)]
  (let [res (test-p-seq index length)]
    (cond
      (= res -1) (recur 0 (dec length))
      (= res 0) (recur (inc index) length)
      (> res 0) (println res))))
