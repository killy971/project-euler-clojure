; A palindromic number reads the same both ways. The largest palindrome made
; from the product of two 2-digit numbers is 9009 = 91 × 99.
; Find the largest palindrome made from the product of two 3-digit numbers.

(defn digits
  [x] (loop [n x, dseq []]
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
  
(defn three-digit-product-biggest-palindrome []
  (loop [a 100, b 100, max 0]
    (let [n (* a b)]
          (cond
            (= 1000 a) max
            (= 1000 b) (recur (inc a) (inc a) max)
            (and (palindromic? n) (> n max)) (recur a (inc b) n)
            :default (recur a (inc b) max)))))

(println (three-digit-product-biggest-palindrome))

; (println (reduce max (filter palindromic? (three-digit-number-product-seq))))
