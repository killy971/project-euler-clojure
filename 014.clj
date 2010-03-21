(defn the-length [x]
  (loop [n x, length 1]
    (if (= 1 n)
      length
      (recur (if (odd? n) (inc (* 3 n)) (quot n 2)) (inc length)))))

(println (reduce max (map the-length (range 1000000))))
