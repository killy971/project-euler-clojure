; (set! *warn-on-reflection* true)

(defn fast-sieve [n]
  "Returns a list of all primes up to n"
  (if (= n 2) '()
    (let [lng (+ (dec (quot n 2)) (rem n 2))
          sieve (int-array (inc lng))
          max-i (quot (int (Math/floor (Math/sqrt n))) 2)]
      (loop [i (int 0), si sieve]
        (if (< i max-i)
          (recur
            (inc i)
            (if (= 1 (aget si i)) si
              (let [jinc (+ (* i 2) 3), #^ints sj si]
                (loop [j (+ (* (* i (+ (int i) 3)) 2) 3)]
                  (if (>= j lng) sj
                    (do (aset sj (int j) (int 1))
                      (recur (+ j jinc))))))))
          (loop [k (int 0), res [2]]
            (if (>= k lng) res
              (recur (inc k)
                     (if (zero? (aget si k))
                       (conj res (+ (* k 2) 3))
                       res)))))))))

; (time (dotimes [i 10] (reduce + (fast-sieve 10000000))))
