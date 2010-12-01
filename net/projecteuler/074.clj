(ns net.projecteuler.074)

(defn fact [digit]
  (case digit
    0 1
    1 1
    2 2
    3 6
    4 24
    5 120
    6 720
    7 5040
    8 40320
    9 362880))

(defn digits-fact [number]
  (loop [n number, res 0]
    (if (< n 10)
      (+ (fact n) res)
      (recur (quot n 10) (+ (fact (rem n 10)) res)))))

(defn chain-length [start]
  (loop [n start, chain (hash-set)]
    (if (contains? chain n)
      (count chain)
      (recur (digits-fact n) (conj chain n)))))

(defn problem-074 []
  (count (filter #(= (chain-length %) 60) (range 1000000))))
