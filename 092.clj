(load-file "utils.clj")

(defn ends-by [n]
  (loop [i n]
    (let [next (reduce + (map #(* % %) (to-d i)))]
      (cond
        (= next 1) 0
        (= next 89) 1
        :default (recur next)))))

(println (reduce + (map ends-by (range 1 10000000))))
