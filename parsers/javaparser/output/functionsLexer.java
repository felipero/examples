// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/felipe/workspaces/examples/parsers/javaparser/functions.g 2010-10-20 17:13:47

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class functionsLexer extends Lexer {
    public static final int NAME=4;
    public static final int LETTER=5;
    public static final int EOF=-1;
    public static final int T__7=7;
    public static final int T__6=6;

    // delegates
    // delegators

    public functionsLexer() {;} 
    public functionsLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public functionsLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/felipe/workspaces/examples/parsers/javaparser/functions.g"; }

    // $ANTLR start "T__6"
    public final void mT__6() throws RecognitionException {
        try {
            int _type = T__6;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/felipe/workspaces/examples/parsers/javaparser/functions.g:3:6: ( '(' )
            // /home/felipe/workspaces/examples/parsers/javaparser/functions.g:3:8: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__6"

    // $ANTLR start "T__7"
    public final void mT__7() throws RecognitionException {
        try {
            int _type = T__7;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/felipe/workspaces/examples/parsers/javaparser/functions.g:4:6: ( ')' )
            // /home/felipe/workspaces/examples/parsers/javaparser/functions.g:4:8: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__7"

    // $ANTLR start "NAME"
    public final void mNAME() throws RecognitionException {
        try {
            int _type = NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/felipe/workspaces/examples/parsers/javaparser/functions.g:6:6: ( ( LETTER )+ )
            // /home/felipe/workspaces/examples/parsers/javaparser/functions.g:6:8: ( LETTER )+
            {
            // /home/felipe/workspaces/examples/parsers/javaparser/functions.g:6:8: ( LETTER )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='A' && LA1_0<='Z')||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/felipe/workspaces/examples/parsers/javaparser/functions.g:6:8: LETTER
            	    {
            	    mLETTER(); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NAME"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            int _type = LETTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/felipe/workspaces/examples/parsers/javaparser/functions.g:7:8: ( 'a' .. 'z' | 'A' .. 'Z' )
            // /home/felipe/workspaces/examples/parsers/javaparser/functions.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LETTER"

    public void mTokens() throws RecognitionException {
        // /home/felipe/workspaces/examples/parsers/javaparser/functions.g:1:8: ( T__6 | T__7 | NAME | LETTER )
        int alt2=4;
        switch ( input.LA(1) ) {
        case '(':
            {
            alt2=1;
            }
            break;
        case ')':
            {
            alt2=2;
            }
            break;
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt2=3;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 2, 0, input);

            throw nvae;
        }

        switch (alt2) {
            case 1 :
                // /home/felipe/workspaces/examples/parsers/javaparser/functions.g:1:10: T__6
                {
                mT__6(); 

                }
                break;
            case 2 :
                // /home/felipe/workspaces/examples/parsers/javaparser/functions.g:1:15: T__7
                {
                mT__7(); 

                }
                break;
            case 3 :
                // /home/felipe/workspaces/examples/parsers/javaparser/functions.g:1:20: NAME
                {
                mNAME(); 

                }
                break;
            case 4 :
                // /home/felipe/workspaces/examples/parsers/javaparser/functions.g:1:25: LETTER
                {
                mLETTER(); 

                }
                break;

        }

    }


 

}