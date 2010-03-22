(ns net.projecteuler.062
  (:use [net.projecteuler.utils :only [to-d]]))

(defn to-key [number]
  (str (sort (to-d number))))

(defn inc-cube [coll]
  (cons (inc (first coll)) (rest coll)))

(defn problem-062 []
  (loop [n 1, cubes {}]
    (let [cube (* n (* n n))
          ckey (to-key cube)]
      (if (contains? cubes ckey)
        (let [next-cubes (assoc cubes ckey (inc-cube (get cubes ckey)))]
          (if (= (first (get next-cubes ckey)) 5)
            (second (get next-cubes ckey)) ; result
            (recur (inc n) next-cubes)))
        (recur (inc n) (assoc cubes ckey [1 cube]))))))
