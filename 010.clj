; Calculate the sum of all the primes below two million.

(load-file "sieve.clj")

(println (reduce + (sieve 2000000)))
