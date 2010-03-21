(load-file "sieve.clj")

(defn set-cons [e l]
  (cond
    (empty? l) (list e)
    (= e (first l)) l
    :default (cons e l)))

(defn unique-prime-factors [primes-seq, x]
  (loop [f-seq (), p-seq primes-seq, n x, r (Math/sqrt x)]
    (let [p (first p-seq)
          d (zero? (rem n p))
          a (= p (first f-seq))]
    (cond
      (> p r) (set-cons n f-seq)
      (= 1 n) f-seq
      (zero? (rem n p)) (let [next-n (quot n p)]
                          (recur (set-cons p f-seq) p-seq next-n (Math/sqrt next-n)))
      :default (recur f-seq (rest p-seq) n r)))))

(defn phi [p-seq, x]
  (reduce #(* %1 (/ (dec %2) %2)) x (unique-prime-factors p-seq x)))

(def phi-m (memoize phi))

(defn update-chain-length [p-seq, lengths, n]
  (if (= 2 n) lengths
    (loop [p (dec n), i 1]
      (if (contains? lengths p)
        (assoc lengths n (+ i (get lengths p)))
        (recur (phi-m p-seq p) (inc i))))))

(defn make-chain-lengths [p-seq]
  (reduce #(update-chain-length p-seq %1 %2) (hash-map 1 1 2 2) p-seq))

(println
  (let [chain-lengths (make-chain-lengths (sieve 4e7))]
    (reduce #(+ %1 (key %2)) 0 (filter #(= 25 (val %)) chain-lengths))))
