(load-file "sieve.clj")
(load-file "utils.clj")

(println (last (filter pandigital? (sieve 7654321))))

; cannot try with numbers containing 8 or 9, because they can't be prime
