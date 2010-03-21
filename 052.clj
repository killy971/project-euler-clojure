(load-file "utils.clj")

(defn same-digits [x]
  (let [d-lists (map #(sort (to-d %))
                     (map #(* % x) (range 2 7)))]
    (every? #(= (first d-lists) %)
            (rest d-lists))))

(println (first (filter same-digits (iterate inc 1))))
