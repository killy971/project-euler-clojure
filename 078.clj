(defn calc-p [p-vec, i]
  (loop [s 0, j 1, k 1, m -1]
    (if (<= j 0) s
      (let [k-sq (* k k)
            j1 (- i (quot (+ (* 3 k-sq) k) 2))
            t (if (< j1 0) s (- s (* m (nth p-vec j1))))
            j2 (- i (quot (- (* 3 k-sq) k) 2))
            u (if (< j2 0) t (- t (* m (nth p-vec j2))))]
        (recur u j2 (inc k) (* -1 m))))))

(loop [p-vec [1], i 1]
  (let [p (calc-p p-vec i)]
    (if (zero? (rem p 1000000)) (println i)
      (recur (conj p-vec p) (inc i)))))
