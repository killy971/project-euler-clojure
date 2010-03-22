(ns net.projecteuler.032
  (:use [net.projecteuler.utils :only [to-n]]
        [clojure.contrib.combinatorics :only [permutations]]))

(defn has-p? [mult prod]
  (let [m1 (to-n (take 1 mult)) m4 (to-n (drop 1 mult))
        m2 (to-n (take 2 mult)) m3 (to-n (drop 2 mult))]
    (or (= (* m1 m4) prod) (= (* m2 m3) prod))))

(def pand-prods
  (loop [perm (permutations (range 1 10)), prods (set [])]
    (if (empty? perm) prods
      (let [digits (first perm)
            mult (take 5 digits)
            prod (to-n (drop 5 digits))]
        (recur (rest perm)
               (if (has-p? mult prod) (conj prods prod) prods))))))

(defn problem-032 []
  (reduce + pand-prods))
