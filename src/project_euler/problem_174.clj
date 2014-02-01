(ns project-euler.problem-174)

(defn update-occ [occ-vect size-list]
  (if (empty? size-list) occ-vect
  (reduce #(assoc %1 %2 (inc (get %1 %2))) occ-vect size-list)))

(defn squares [start-side max-tiles occ-vect]
  (loop [size-list (list (* 4 (dec start-side)))
         occurences occ-vect]
    (if (empty? size-list)
      occurences
      (let [head (+ 8 (first size-list))
            result (cons head (map #(+ head %) size-list)) ]
        (recur
          (take-while #(<= % max-tiles) result)
          (update-occ occurences size-list))))))

(defn squares-occurences [max-tiles]
  (squares 3 max-tiles
           (squares 4 max-tiles
                    (vec (make-array Integer/TYPE (inc max-tiles))))))

(defn solution-174 []
  (count (filter #(and (<= 1 %) (>= 10 %)) (squares-occurences 1000000))))
