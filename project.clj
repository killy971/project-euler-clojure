(defproject project-euler "0.1.0-SNAPSHOT"
  :description "Solutions to Project Euler problems"
  :url "https://github.com/killy971/project-euler/clojure"
  :license {:name "BSD3"
            :url "http://opensource.org/licenses/BSD-3-Clause"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/math.combinatorics "0.0.7"]
                 [org.clojure/math.numeric-tower "0.0.4"]]
  :main ^:skip-aot project-euler.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
