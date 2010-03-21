(defn digits
  [x]
  (loop [n x, dseq []]
    (if (< n 10)
      (cons n dseq)
      (recur (quot n 10) (cons (rem n 10) dseq)))))

(defn fact [n]
  (loop [i n, f 1]
    (if (zero? i) f (recur (dec i) (* f i)))))

(def fact-m (memoize fact))

(defn eq-sum-of-fact [n]
  (and (> n 9)
       (= n (reduce + (map fact-m (digits n))))))

(println (reduce + (filter eq-sum-of-fact (range 100000))))
