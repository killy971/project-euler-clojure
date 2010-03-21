(def fib-seq
  ((fn fib [a b] (lazy-seq (cons a (fib b (+ a b))))) 1 1))

(def first-thousand-digit-fib
  (ffirst
    (filter #(= (count (str (second %))) 1000)
            (map vector (iterate inc 1) fib-seq))))

(println first-thousand-digit-fib)
