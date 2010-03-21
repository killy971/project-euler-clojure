(defn digits [x]
  (loop [n x, dseq []]
    (if (< n 10)
      (cons n dseq)
        (recur (quot n 10) (cons (rem n 10) dseq)))))

(defn ends-by [n]
  (loop [i n]
    (let [next (reduce + (map #(* % %) (digits i)))]
      (cond
        (= next 1) 0
        (= next 89) 1
        :default (recur next)))))

(println (reduce + (map ends-by (range 1 10000000))))
