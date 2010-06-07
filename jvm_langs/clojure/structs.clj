(defstruct Car :model :year)
(def meuCarro (struct Car "Celta" 2007))

(println meuCarro)

; Acessando um atributo
(:model meuCarro) 

(defn whichModel
  [brand]
  (if (= brand "GM") "Celta"))

; No lugar do atributo :year passamos uma função anônima
(def meuCarroExe (struct Car "Celta" (fn [] (- 2010 3))))

(def celta (struct Car (whichModel "GM") 2007))

; Executamos a função anônima obtendo o valor dela e envolvendo-a em parenteses
((:year meuCarroExe))
(println (str "Modelo -> " (:model celta)))

