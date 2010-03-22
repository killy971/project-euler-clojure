(ns net.projecteuler.012)

(defn divisors-count [n]
  (* 2 (count (filter #(zero? (rem n %))
                      (range 1 (Math/sqrt n))))))

(def triangle-seq
  (lazy-seq
    (cons 0 (map + triangle-seq (iterate inc 1)))))

(defn problem-012 []
  (first (filter #(> (divisors-count %) 500) triangle-seq)))
