; stack-consuming-fibo
; bad idea
(defn stack-consuming-fibo [n]
  (cond
   (= n 0) 0
   (= n 1) 1
   :else (+ (stack-consuming-fibo (- n 1))
	    (stack-consuming-fibo (- n 2)))))

; recur-fibo    
; better but not great
(defn recur-fibo [n]
  (letfn [(fib 
	   [current next n]
	   (if (zero? n)
	     current
	     (recur next (+ current next) (dec n))))]
    (fib 0 1 n)))

; lazy-seq-fibo
(defn lazy-seq-fibo 
  ([] 
     (concat [0 1] (lazy-seq-fibo 0 1)))
  ([a b]
     (let [n (+ a b)]                   
       (lazy-seq                        
	(cons n (lazy-seq-fibo b n))))))

; fibo
(defn fibo []
 (map first (iterate (fn [[a b]] [b (+ a b)]) [0 1])))