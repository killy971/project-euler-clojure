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

(defn palindromic?  [x]
  (let [half (split-half (digits x))]
    (= (first half) (reverse (second half)))))

(defn rev-int [x]
  (reduce + (map * (digits x) (iterate #(* 10 %) 1))))

(defn lychrel? [x]
  (loop [n x, i 50]
    (let [next (+ n (rev-int n))]
      (cond
        (zero? i) true
        (palindromic? next) false
        :default (recur next (dec i))))))

(println (count (filter lychrel? (range 10000))))
