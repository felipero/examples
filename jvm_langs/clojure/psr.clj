(use '[clojure.contrib.lazy-seqs :only (primes)])
(use 'clojure.contrib.math)

(defn poput
  ([]
     (poput 190))
  ([n]
     (reduce * (take-while #(< % n) primes))
))

(defn integer-sqrt-of-poput [n]
  (first (exact-integer-sqrt (poput n)))
)

(defn psr
  ([]
     (psr (integer-sqrt-of-poput 190)))
  ([d]
     (when-not (= d 0)
       (let [n (mod (poput) d)]
	 (if (= n 0)
	   (lazy-seq
	    (cons d (psr (- d 1))))
	   ))))
  )
  
(defn psr-new [n, limit]
 (take-while (and #(<= % limit) #(= (mod n %) 0)) (range 1 (+ limit 1))))

(defn divisors [d, limit]
 (for [n (range 1 (+ limit 1)) :when (= (mod d n) 0)] n))
; (take-while #(= (mod n %) 0) (range 1 (+ limit 1))))

;(divisors 4550 (first (exact-integer-sqrt 4550)))
;(last (divisors (poput 190) (integer-sqrt-of-poput 190)))



