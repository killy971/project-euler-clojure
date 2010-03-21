(load-file "utils.clj")

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

(println (count (filter #(= (chain-length %) 60) (range 1000000))))
