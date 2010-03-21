(load-file "utils.clj")

(defn sum-even-fib [max]
  (reduce + (filter odd? (take-while #(< % max) fib-seq))))

(println (sum-even-fib 4000000))
