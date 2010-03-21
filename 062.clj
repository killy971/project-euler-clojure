(set! *warn-on-reflection* true)

(defn to-d [number]
  (loop [n number, dseq []]
    (if (< n 10)
      (cons n dseq)
      (recur (quot n 10) (cons (rem n 10) dseq)))))

(defn to-key [number]
  (str (sort (to-d number))))

(defn inc-cube [coll]
  (cons (inc (first coll)) (rest coll)))

(loop [n 1, cubes {}]
  (let [cube (* n (* n n))
        ckey (to-key cube)]
    (if (contains? cubes ckey)
      (let [next-cubes (assoc cubes ckey (inc-cube (get cubes ckey)))]
        (if (= (first (get next-cubes ckey)) 5)
          (println (second (get next-cubes ckey)))
          (recur (inc n) next-cubes)))
      (recur (inc n) (assoc cubes ckey [1 cube])))))
