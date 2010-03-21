(load-file "sieve.clj")

(def primes-seq (sieve 1000000))

(defn set-cons [e l]
  (cond
    (empty? l) (list e)
    (= e (first l)) l
    :default (cons e l)))

(defn unique-prime-factors [x]
  (loop [f-seq (), p-seq primes-seq, n x, r (Math/sqrt x)]
    (let [p (first p-seq)
          d (zero? (rem n p))
          a (= p (first f-seq))]
    (cond
      (> p r) (reverse (set-cons n f-seq))
      (= 1 n) (reverse f-seq)
      (zero? (rem n p)) (let [next-n (quot n p)]
                          (recur (set-cons p f-seq) p-seq next-n (Math/sqrt next-n)))
      :default (recur f-seq (rest p-seq) n r)))))

(defn phi [x]
  (reduce #(* %1 (/ (dec %2) %2)) x (unique-prime-factors x)))

(println (reduce + (map phi (range 2 1000001))))
