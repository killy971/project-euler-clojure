(def fib-seq
  ((fn fib [a b] (lazy-seq (cons a (fib b (+ a b))))) 1 1))

(defn digits [x]
  (loop [n x, dseq ()]
    (if (< n 10)
      (cons n dseq)
      (recur (quot n 10) (cons (rem n 10) dseq)))))

(defn nine-pandigital? [digit-list]
  (let [d-list (sort digit-list)]
    (and
      (not= 0 (first d-list))
      (= d-list (range 1 10)))))

(println (time (ffirst (filter
                  #(let [d-list (digits (second %)) len (count d-list)]
                     (and
                       (nine-pandigital? (take 9 d-list))
                       (nine-pandigital? (drop (- len 9) d-list))))
                  (map #(list %2 %1) fib-seq (iterate inc 1))))))
