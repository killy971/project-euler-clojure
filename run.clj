(import java.text.DecimalFormat)

(set! *warn-on-reflection* true)

(def *all-problems-list*
  '(1 2 4 6 8 9 10 12 14 21 24 25 26 32 34 36 39 41 46 49 52 55 56 57 58 62 65 70
      71 72 73 74 87 92 97 124 173 174 179 187 214))

(defn run [n]
  (let [number (.format (new DecimalFormat "000") n)
        problem (symbol (str "problem-" number))]
    (use (vec (list (symbol (str "net.projecteuler." number))
                    :only (list problem))))
    (print (format "problem %s: " number))
    (println (eval (list problem)))))

(let [problem (second *command-line-args*)]
  (if (nil? problem)
    (doseq [n *all-problems-list*]
      (time (run n)))
    (time (run (Integer/parseInt problem)))))
