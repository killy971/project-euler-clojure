(defn root-exp-list [n]
  (loop [i n, l [(inc (/ 2))]]
    (if (zero? i) (reverse l)
      (recur (dec i) (cons (inc (/ (inc (first l)))) l)))))

(defn digit-count [x]
  (loop [n x, d-count 1]
    (if (< n 10) d-count (recur (quot n 10) (inc d-count)))))

(defn more-numer-digits-than-denom [x]
  (> (digit-count (.numerator x)) (digit-count (.denominator x))))

(println (count (filter more-numer-digits-than-denom
                        (root-exp-list 1000))))
