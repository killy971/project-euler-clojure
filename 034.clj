(load-file "utils.clj")

(def fact-m (memoize fact))

(defn eq-sum-of-fact [n]
  (and (> n 9)
       (= n (reduce + (map fact-m (to-d n))))))

(println (reduce + (filter eq-sum-of-fact (range 100000))))
