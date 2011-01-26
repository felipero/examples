package my.parser;

public class ListLexer extends Lexer {

	public ListLexer(String input) {
		super(input);
	}

	public static String[] tokenNames = { "n/a", "<EOF>", "NAME", "COMMA",
		"LBRACK", "RBRACK" };
	
	@Override
	public Token nextToken() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTokenName(int tokenType) {
		// TODO Auto-generated method stub
		return null;
	}

}
