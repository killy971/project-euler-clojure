(set! *warn-on-reflection* true)

(load-file "sieve.clj")

(def primes-seq (sieve 10000000))

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

(defn to-digits [number]
  (loop [n number, dseq []]
    (if (< n 10)
      (cons n dseq)
      (recur (quot n 10) (cons (rem n 10) dseq)))))

(defn to-number [digits]
  (reduce + (map * (reverse digits) (iterate #(* 10 %) 1))))

(defn permute [l]
  (concat (rest l) (take 1 l)))

(defn is-permutation [x y]
  (let [d-list (to-digits x)]
    (loop [i (dec (count d-list)), next-permutation (permute d-list)]
      (cond
        (zero? i) false
        (= y (to-number next-permutation)) true
        :default (recur (dec i) (permute next-permutation))))))

(defn min-ratio [max-n]
  (loop [n 11, n-for-min 87109, min-r (/ 87109 79180)]
    (let [phi-n (phi n) r (/ n phi-n)]
      (cond
        (= n max-n) n-for-min
        (and (< r min-r) (is-permutation n phi-n)) (recur (inc n) n r)
        :default (recur (inc n) n-for-min min-r)))))

(println (min-ratio 10000000))
