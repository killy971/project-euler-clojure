(use 'clojure.contrib.combinatorics)

(defn nth-permutation [n]
  (nth (permutations (range 10)) (dec n)))

(println
  (reduce str (nth-permutation 1000000)))
