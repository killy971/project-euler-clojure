(ns net.projecteuler.097)

(defn last-n-digits [x n] (rem x (long (Math/pow 10 n))))

(defn partial-pow
  [x p init n]
  (loop [i p,  acc (* init x)]
    (if (== 1 i)
      acc
      (recur (dec i) (last-n-digits (* 2 acc) n)))))

(defn problem-097 []
  (inc (partial-pow 2 7830457 28433 10)))
