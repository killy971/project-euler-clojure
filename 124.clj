(load-file "sieve.clj")

(defn make-rads [limit]
  (loop [p-seq (sieve limit),
         p (first p-seq),
         i p,
         rads (vec (int-array limit 1))]
    (cond
      (= 1 (count p-seq)) rads
      (>= i limit) (recur (rest p-seq) (second p-seq) (second p-seq) rads)
      :default (recur p-seq p
                      (+ i p)
                      (assoc rads i (* p (nth rads i)))))))

(let [rads (make-rads 1e5)]
  (println
    (nth (sort-by #(nth rads %) (range 1e5)) 10000)))
