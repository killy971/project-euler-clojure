(defn multof [x n] (zero? (rem x n)))

(println (reduce + (filter (fn [x] (or (multof x 3)
                                       (multof x 5)))
                           (range 1000))))
