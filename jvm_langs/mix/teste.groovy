import clojure.lang.Compiler
import clojure.lang.RT

@Grab(group='org.clojure', module='clojure', version='1.0.0')
class teste {

    static void main(String [] args){
        println "=== inside main ==="
        def src = new File('temp.clj')
        src.text = '''
(ns groovy)
(defn factorial [n]
   (if (< n 2)
       1
       (* n (factorial (- n 1)))))
'''
        
        src.withReader { reader ->
            Compiler.load reader
        }
        
        def fac = RT.var('groovy', 'factorial')    
        println fac.invoke(5)
    }
}
