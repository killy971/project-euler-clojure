(use 'de.tsdh.math.primes) ; miller-rabin pseudo primality test

(defn next-diag [start-val side]
  (map #(+ start-val (* (dec side) %)) (range 1 5)))

(defn side-for-ratio [threshold-ratio]
  (loop [start-val 1, side 3, prime-count 0, n 1]
    (let [diag-seq (next-diag start-val side)
          primes (count (filter prime? diag-seq))
          next-prime-count (+ prime-count primes)
          next-n (+ n 4)]
      (if (< (* next-prime-count threshold-ratio) next-n)
        side
        (recur
          (last diag-seq)
          (+ side 2)
          next-prime-count
          next-n)))))

((println (side-for-ratio 10))
