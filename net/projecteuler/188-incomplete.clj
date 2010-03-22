(ns net.projecteuler.188
  (:use [clojure.contrib.math :only [exp]]))

(defn fast-exp-mod [n e m]
  (loop [r 1, b n, exp e]
    (if (zero? exp) r
      (recur (if (odd? exp) (mod (* r b) m) r)
             (mod (expt b 2) m)
             (bit-shift-right exp 1)))))
