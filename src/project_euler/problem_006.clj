(ns project-euler.problem-006)

(defn solution-006 []
  (int (- (Math/pow (reduce + (range 101)) 2)
          (reduce + (map #(Math/pow % 2) (range 101))))))
