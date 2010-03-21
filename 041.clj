(load-file "sieve.clj")

(defn digits [x]
  (loop [n x, dseq ()]
    (if (< n 10)
      (cons n dseq)
      (recur (quot n 10) (cons (rem n 10) dseq)))))

(defn pandigital? [x]
  (let [d-list (sort (digits x))]
    (and
      (< 0 (first d-list))
      (= d-list (range 1 (inc (count d-list)))))))

(println (last (filter pandigital? (sieve 7654321))))

; cannot try with numbers containing 8 or 9, because they can't be prime
