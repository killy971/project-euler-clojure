(load-file "utils.clj")

(def first-thousand-digit-fib
  (ffirst
    (filter #(= (count (str (second %))) 1000)
            (map vector (iterate inc 1) fib-seq))))

(println first-thousand-digit-fib)
