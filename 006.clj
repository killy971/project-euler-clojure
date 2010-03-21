(println (int (- (Math/pow (reduce + (range 101)) 2) (reduce + (map #(Math/pow % 2) (range 101))))))
