(defn digits [x]
  (loop [n x, dseq []]
    (if (< n 10)
      (cons n dseq)
      (recur (quot n 10) (cons (rem n 10) dseq)))))

(defn split-half [l]
  (let [size (count l)
        half-size (quot size 2)]
    (let [first-half (take half-size l)]
      (if (even? size)
        [first-half (drop half-size l)]
        [first-half (drop (inc half-size) l)]))))

(defn palindromic?  [digit-list]
  (let [half (split-half digit-list)]
    (= (first half) (reverse (second half)))))

(defn dec-to-bin [x]
  (loop [n x, b ()]
    (if (zero? n) b (recur (quot n 2) (cons (rem n 2) b)))))

(defn dec-bin-palindromic? [x]
  (and (palindromic? (digits x))
       (palindromic? (dec-to-bin x))))

(println (reduce + (filter dec-bin-palindromic? (range 1000000))))
