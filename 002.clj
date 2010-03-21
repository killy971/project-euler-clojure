(def fib-seq
  ((fn fib [a b]
     (lazy-seq (cons a (fib b (+ a b))))) 1 1))

(defn sum-even-fib [max]
  (reduce + (filter odd? (take-while #(< % max) fib-seq))))

(println (sum-even-fib 4000000))
