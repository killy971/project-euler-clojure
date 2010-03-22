(ns net.projecteuler.104
  (:use [net.projecteuler.utils :only [fib-seq to-d]]))

(defn nine-pandigital? [digit-list]
  (let [d-list (sort digit-list)]
    (and
      (not= 0 (first d-list))
      (= d-list (range 1 10)))))

(defn problem-104 []
  (ffirst (filter
            #(let [d-list (to-d (second %)) len (count d-list)]
               (and
                 (nine-pandigital? (take 9 d-list))
                 (nine-pandigital? (drop (- len 9) d-list))))
            (map #(list %2 %1) fib-seq (iterate inc 1)))))
