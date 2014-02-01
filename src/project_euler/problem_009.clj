(ns project-euler.problem-009)

(defn solution-009 []
  (loop [a 1, b 2, c 997]
    (cond
      (= (+ (Math/pow a 2) (Math/pow b 2)) (Math/pow c 2)) (* a b c)
      (< c b) (recur (inc a) (+ a 2) (- 1000 a 3))
      :default (recur a (inc b) (- 1000 a b 1)))))
