(ns project-euler.core)

(set! *warn-on-reflection* true)

(defn run-problem [n]
  (let [number (.format (new java.text.DecimalFormat "000") n)
        solution (symbol (str "solution-" number))]
    (use (vec (list (symbol (str "project-euler.problem-" number))
                    :only (list solution))))
    (eval (list solution))))

(defn -main
  "Solution runner"
  [& args]
  (if (and args (= 1 (count args)))
    (println (time (run-problem (Integer/parseInt (first args)))))
    (println "Usage: lein run [number]")))
