(ns net.projecteuler.040)

(defn digits-vec [x]
  (loop [n x, dseq []]
    (if (< n 10)
      (vec (cons n dseq))
      (recur (quot n 10) (cons (rem n 10) dseq)))))

(def positives-digits-seq
  (lazy-cat (map digits-vec (iterate inc 1))))
