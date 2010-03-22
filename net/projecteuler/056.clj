(ns net.projecteuler.056
  (:use [net.projecteuler.utils :only [to-d]]))

(defn big-pow [a b]
  (reduce * (repeat b a)))

(defn biggest-power-digit-sum [max]
  (loop [a 2, b 2, bpds 0]
    (cond
      (= max a) bpds
      (= max b) (recur (inc a) 2 bpds)
      :default (recur a (inc b) (let [s (reduce + (to-d (big-pow a b)))]
                                  (if (> s bpds) s bpds))))))

(defn problem-056 []
  (biggest-power-digit-sum 100))
