; A palindromic number reads the same both ways. The largest palindrome made
; from the product of two 2-digit numbers is 9009 = 91 × 99.
; Find the largest palindrome made from the product of two 3-digit numbers.

(load-file "utils.clj")

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
