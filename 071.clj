(defn closest-fraction-numerator [numer denom max-denom]
  (let [upper (/ numer denom)]
    (loop [n numer, d (inc denom), c-n 0, c-f 0]
      (cond
        (= max-denom d) c-n
        (< (/ (inc n) d) upper) (recur (inc n) d c-n c-f)
        :default (let [f (/ n d) closer (> f c-f)]
                   (recur n (inc d) (if closer n c-n) (if closer f c-f)))))))

(println (closest-fraction-numerator 3 7 1000000))
