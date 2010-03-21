(defn digits
  [x]
  (loop [n x, dseq []]
    (if (< n 10)
      (cons n dseq)
      (recur (quot n 10) (cons (rem n 10) dseq)))))

(defn big-pow [a b]
  (loop [n a, i b]
    (if (= i 1) n (recur (* a n) (dec i)))))

(defn biggest-power-digit-sum [max]
  (loop [a 2, b 2, bpds 0]
    (cond
      (= max a) bpds
      (= max b) (recur (inc a) 2 bpds)
      :default (recur a (inc b) (let [s (reduce + (digits (big-pow a b)))]
                                  (if (> s bpds) s bpds))))))

(println (biggest-power-digit-sum 100))
