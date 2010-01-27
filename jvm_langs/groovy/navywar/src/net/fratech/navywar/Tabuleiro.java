import java.util.Map;
import java.util.HashMap;

public class Tabuleiro {

    Map<Object, Object> celulas = new HashMap<Object, Object>();

    public Tabuleiro(int tamanho){
	if(tamanho < 4 || tamanho > 20){
	    throw new IllegalArgumentException("Tamanho menor que o mínimo.");
	}

	for(int i = 1; i <= tamanho; i++){

	    for(int j = 1 ; j <= tamanho; j++){
		celulas.put(criarChave(i, j), null);
	    }
	}
    }

    public void inserirNavio(String chave, String nome){
	celulas.put(chave, nome);
    }

    private String criarChave(int col, int linha){
	char coluna = Character.toChars(64 + col)[0];
	return coluna +":"+linha;
    }
}