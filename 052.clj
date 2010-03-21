(defn digits
  [x]
  (loop [n x, dseq []]
    (if (< n 10)
      (cons n dseq)
      (recur (quot n 10) (cons (rem n 10) dseq)))))

(defn same-digits [x]
  (let [d-lists
        (map #(sort (digits %))
             (map #(* % x)
                  (range 2 7)))]
    (every? #(= (first d-lists) %)
            (rest d-lists))))

(println (first (filter same-digits (iterate inc 1))))
