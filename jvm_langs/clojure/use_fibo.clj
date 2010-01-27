(require 'fibo)

(def fibos (take 40000000 (fibo)))

(println (nth fibos 1000))


(println (nth (lazy-seq-fibo) 1000000))
