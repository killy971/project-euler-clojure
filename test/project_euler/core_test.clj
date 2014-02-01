(ns project-euler.core-test
  (:require [clojure.test :refer :all]
            [project-euler.problem-001 :refer [solution-001]]
            [project-euler.problem-002 :refer [solution-002]]
            [project-euler.problem-004 :refer [solution-004]]
            [project-euler.problem-006 :refer [solution-006]]
            [project-euler.problem-008 :refer [solution-008]]
            [project-euler.problem-009 :refer [solution-009]]
            [project-euler.problem-010 :refer [solution-010]]
            [project-euler.problem-012 :refer [solution-012]]
            [project-euler.problem-014 :refer [solution-014]]
            [project-euler.problem-021 :refer [solution-021]]
            [project-euler.problem-024 :refer [solution-024]]
            [project-euler.problem-025 :refer [solution-025]]
            [project-euler.problem-026 :refer [solution-026]]
            [project-euler.problem-032 :refer [solution-032]]
            [project-euler.problem-034 :refer [solution-034]]
            [project-euler.problem-036 :refer [solution-036]]
            [project-euler.problem-039 :refer [solution-039]]
            [project-euler.problem-041 :refer [solution-041]]
            [project-euler.problem-046 :refer [solution-046]]
            [project-euler.problem-049 :refer [solution-049]]
            [project-euler.problem-052 :refer [solution-052]]
            [project-euler.problem-055 :refer [solution-055]]
            [project-euler.problem-056 :refer [solution-056]]
            [project-euler.problem-057 :refer [solution-057]]
            [project-euler.problem-058 :refer [solution-058]]
            [project-euler.problem-062 :refer [solution-062]]
            [project-euler.problem-065 :refer [solution-065]]
            [project-euler.problem-070 :refer [solution-070]]
            [project-euler.problem-071 :refer [solution-071]]
            [project-euler.problem-072 :refer [solution-072]]
            [project-euler.problem-073 :refer [solution-073]]
            [project-euler.problem-074 :refer [solution-074]]
            [project-euler.problem-087 :refer [solution-087]]
            [project-euler.problem-092 :refer [solution-092]]
            [project-euler.problem-097 :refer [solution-097]]
            [project-euler.problem-124 :refer [solution-124]]
            [project-euler.problem-173 :refer [solution-173]]
            [project-euler.problem-174 :refer [solution-174]]
            [project-euler.problem-179 :refer [solution-179]]
            [project-euler.problem-187 :refer [solution-187]]
            [project-euler.problem-214 :refer [solution-214]]))

(deftest all-solutions
  (testing "All solutions Project Euler"
    (is (= (solution-001) 233168))
    (is (= (solution-002) 4613732))
    (is (= (solution-004) 906609))
    (is (= (solution-006) 25164150))
    (is (= (solution-008) 40824))
    (is (= (solution-009) 31875000))
    (is (= (solution-010) 142913828922))
    (is (= (solution-012) 76576500))
    (is (= (solution-014) 837799))
    (is (= (solution-021) 31626))
    (is (= (solution-024) "2783915460"))
    (is (= (solution-025) 4782))
    (is (= (solution-026) 983))
    (is (= (solution-032) 45228))
    (is (= (solution-034) 40730))
    (is (= (solution-036) 872187))
    (is (= (solution-039) 840))
    (is (= (solution-041) 7652413))
    (is (= (solution-046) 5777))
    (is (= (solution-049) 296962999629))
    (is (= (solution-052) 142857))
    (is (= (solution-055) 249))
    (is (= (solution-056) 972))
    (is (= (solution-057) 153))
    (is (= (solution-058) 26241))
    (is (= (solution-062) 127035954683))
    (is (= (solution-065) 272))
    (is (= (solution-071) 428570))
    (is (= (solution-072) 303963552391))
    (is (= (solution-073) 5066251))
    (is (= (solution-087) 1097343))
    (is (= (solution-097) 8739992577))
    (is (= (solution-124) 21417))
    (is (= (solution-173) 1572729))
    (is (= (solution-174) 209566))
    (is (= (solution-187) 17427258))))

(comment deftest slow-solutions
  (testing "Slow solutions"
    (is (= (solution-070) ?))
    (is (= (solution-074) 402))
    (is (= (solution-092) 8581146))
    (is (= (solution-179) 986262))
    (is (= (solution-214) 1677366278943))))
