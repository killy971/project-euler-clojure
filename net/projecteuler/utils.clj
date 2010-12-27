(ns net.projecteuler.utils)

(defn fact [n]
  (if (zero? n) 1 (reduce * n (range 2 n))))

; --------------------------------------------------------------------------- ;

(defn to-n [digits]
  (reduce + (map * (reverse digits) (iterate #(* 10 %) 1))))

(defn to-d [number]
  (loop [n number, digit-seq []]
    (if (< n 10)
      (cons n digit-seq)
      (recur (quot n 10) (cons (rem n 10) digit-seq)))))

; --------------------------------------------------------------------------- ;

(def fib-seq
  ((fn fib [a b] (lazy-seq (cons a (fib b (+ a b))))) 1 1))

; --------------------------------------------------------------------------- ;

(defn pandigital? [x]
  (let [d-list (sort (to-d x))]
    (and
      (< 0 (first d-list))
      (= d-list (range 1 (inc (count d-list)))))))

; --------------------------------------------------------------------------- ;

(defn split-half [l]
  (let [size (count l)
        half-size (quot size 2)]
    (let [first-half (take half-size l)]
      (if (even? size)
        [first-half (drop half-size l)]
        [first-half (drop (inc half-size) l)]))))

(defn palindromic?  [x]
  (let [half (split-half (to-d x))]
    (= (first half) (reverse (second half)))))

; --------------------------------------------------------------------------- ;

(defn set-cons [e l]
  (cond
    (empty? l) (list e)
    (= e (first l)) l
    :default (cons e l)))

(defn unique-prime-factors [primes-seq, x]
  (loop [f-seq (), p-seq primes-seq, n x, r (Math/sqrt x)]
    (let [p (first p-seq)
          d (zero? (rem n p))
          a (= p (first f-seq))]
    (cond
      (> p r) (set-cons n f-seq)
      (= 1 n) f-seq
      (zero? (rem n p)) (let [next-n (quot n p)]
                          (recur (set-cons p f-seq) p-seq next-n (Math/sqrt next-n)))
      :default (recur f-seq (rest p-seq) n r)))))

(defn phi [p-seq, x]
  (reduce #(* %1 (/ (dec %2) %2)) x (unique-prime-factors p-seq x)))

; --------------------------------------------------------------------------- ;

; original code by Rich Hickey

(defn sieve [n]
  (let [n (int n)]
  "Returns a list of all primes from 2 to n"
    (let [root (int (inc (Math/floor (Math/sqrt n))))]
      (loop [i (int 3)
             a (int-array n)
             result [2]]
        (if (>= i n) result
          (recur (+ i (int 2))
                 (if (< i root)
                   (loop [arr a
                          inc (+ i i)
                          j (* i i)]
                     (if (>= j n)
                       arr
                       (recur (do (aset arr j (int 1)) arr)
                              inc
                              (+ j inc))))
                   a)
                 (if (zero? (aget a i))
                   (conj result i)
                   result)))))))

; --------------------------------------------------------------------------- ;

(defn index-of [keep-func, coll]
  (loop [i 0
         a (first coll)
         l (rest coll)
         keep-i i]
    (if (empty? l)
      keep-i
      (let [keep (keep-func a (first l))]
        (recur
          (inc i) (if keep a (first l)) (rest l) (if keep keep-i (inc i)))))))


; --------------------------------------------------------------------------- ;

(defmacro caseify [f n]
  `(fn [x#] (case x# ~@(mapcat (juxt identity (resolve f)) (range n)))))
