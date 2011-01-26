// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g 2010-10-20 17:17:24

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class NameListLexer extends Lexer {
    public static final int NAME=4;
    public static final int WS=6;
    public static final int LETTER=5;
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int T__8=8;
    public static final int T__7=7;

    // delegates
    // delegators

    public NameListLexer() {;} 
    public NameListLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public NameListLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g"; }

    // $ANTLR start "T__7"
    public final void mT__7() throws RecognitionException {
        try {
            int _type = T__7;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:3:6: ( '[' )
            // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:3:8: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__7"

    // $ANTLR start "T__8"
    public final void mT__8() throws RecognitionException {
        try {
            int _type = T__8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:4:6: ( ']' )
            // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:4:8: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__8"

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:5:6: ( ',' )
            // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:5:8: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__9"

    // $ANTLR start "NAME"
    public final void mNAME() throws RecognitionException {
        try {
            int _type = NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:10:10: ( ( LETTER )+ )
            // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:10:12: ( LETTER )+
            {
            // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:10:12: ( LETTER )+
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
            	    // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:10:12: LETTER
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
            // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:11:10: ( 'a' .. 'z' | 'A' .. 'Z' )
            // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:
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

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:12:10: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
            // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:12:12: ( ' ' | '\\t' | '\\n' | '\\r' )+
            {
            // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:12:12: ( ' ' | '\\t' | '\\n' | '\\r' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\t' && LA2_0<='\n')||LA2_0=='\r'||LA2_0==' ') ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:1:8: ( T__7 | T__8 | T__9 | NAME | LETTER | WS )
        int alt3=6;
        switch ( input.LA(1) ) {
        case '[':
            {
            alt3=1;
            }
            break;
        case ']':
            {
            alt3=2;
            }
            break;
        case ',':
            {
            alt3=3;
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
            alt3=4;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt3=6;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 3, 0, input);

            throw nvae;
        }

        switch (alt3) {
            case 1 :
                // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:1:10: T__7
                {
                mT__7(); 

                }
                break;
            case 2 :
                // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:1:15: T__8
                {
                mT__8(); 

                }
                break;
            case 3 :
                // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:1:20: T__9
                {
                mT__9(); 

                }
                break;
            case 4 :
                // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:1:25: NAME
                {
                mNAME(); 

                }
                break;
            case 5 :
                // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:1:30: LETTER
                {
                mLETTER(); 

                }
                break;
            case 6 :
                // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:1:37: WS
                {
                mWS(); 

                }
                break;

        }

    }


 

}