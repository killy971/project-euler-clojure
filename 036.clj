(load-file "utils.clj")

(defn dec-to-bin [x]
  (to-n (loop [n x, b ()]
          (if (zero? n) b (recur (quot n 2) (cons (rem n 2) b))))))

(defn dec-bin-palindromic? [x]
  (and (palindromic? x)
       (palindromic? (dec-to-bin x))))

(println (reduce + (filter dec-bin-palindromic? (range 1000000))))
