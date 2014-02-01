(ns project-euler.problem-179)

(defn make-divs-seq [limit]
  (let [lim (int limit)]
    (loop [i (int 0), d (int 2), divs (int-array limit 1)]
      (if (= d limit) divs
        (if (>= i limit) (recur (int 0) (inc d) divs)
          (recur (+ i d) d (do (aset divs i (inc (aget divs i))) divs)))))))

(defn same-cnt [divs]
  (let [divs2 (cons 0 (seq divs))]
    (reduce + (map #(if (= %1 %2) 1 0) divs divs2))))

(defn solution-179 []
  (let [divs-seq (make-divs-seq (int 1e7))]
    (same-cnt divs-seq)))
