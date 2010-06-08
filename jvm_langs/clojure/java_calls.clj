; Utilização de classes java
(def rnd (new java.util.Random))
(println (. rnd nextInt))

; Importação de classes
(import '(java.util Random)
	'(java.text MessageFormat))

; Construindo novas instâncias
(def rnd (new Random))

; Chamada de métodos com parâmetros
(println (. rnd nextInt 200))

; Métodos estáticos
(println (. Math PI))
(println (System/currentTimeMillis))