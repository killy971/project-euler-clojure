(ns net.projecteuler.001)

(defn multof [x n] (zero? (rem x n)))

(defn problem-001 []
  (reduce + (filter (fn [x] (or (multof x 3)
                                (multof x 5)))
                    (range 1000))))
