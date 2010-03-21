(defn is-right? [a b c]
  (= (+ (* a a) (* b b)) (* c c)))

(defn sol-for-p [p]
  (loop [a 1, b 1, c (- p 2), n 0]
    (let [next-n (if (is-right? a b c) (inc n) n)]
      (cond
        (and (= a b) (< c (+ b 2))) n
        (> b (- c 3)) (recur (inc a) (inc a) (- p a a 2) next-n)
        :default (recur a (inc b) (dec c) next-n)))))

(defn max-solutions-p [max]
  (loop [p 5, max-sol-p 0, max-sol 0]
    (let [sol (sol-for-p p)]
      (if (> p max)
        max-sol-p
        (if (> sol max-sol)
          (recur (inc p) p sol)
          (recur (inc p) max-sol-p max-sol))))))

(println (max-solutions-p 1000))
