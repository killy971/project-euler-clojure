(defn divisors-count [n]
  (* 2 (count (filter #(zero? (rem n %))
                      (range 1 (Math/sqrt n))))))

(def triangle-seq
  (lazy-seq (cons 0 (map +
                         triangle-seq
                         (iterate inc 1)))))

(println (first (filter
                  #(> (divisors-count %) 500)
                  triangle-seq)))
