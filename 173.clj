(defn squares [start-side max-tiles]
  (loop [size-list (list (* 4 (dec start-side))),
         squares-count 0]
    (if (empty? size-list)
      squares-count
      (let [head (+ 8 (first size-list))
            result (cons head (map #(+ head %) size-list))]
        (recur
          (take-while #(<= % max-tiles) result)
          (+ squares-count (count size-list)))))))

(defn squares-number [max-tiles]
  (+ (squares 3 max-tiles) (squares 4 max-tiles)))

(println (squares-number 1000000))
