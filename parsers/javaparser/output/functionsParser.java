// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/felipe/workspaces/examples/parsers/javaparser/functions.g 2010-10-20 17:13:47

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class functionsParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "LETTER", "'('", "')'"
    };
    public static final int NAME=4;
    public static final int LETTER=5;
    public static final int EOF=-1;
    public static final int T__7=7;
    public static final int T__6=6;

    // delegates
    // delegators


        public functionsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public functionsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return functionsParser.tokenNames; }
    public String getGrammarFileName() { return "/home/felipe/workspaces/examples/parsers/javaparser/functions.g"; }



    // $ANTLR start "stat"
    // /home/felipe/workspaces/examples/parsers/javaparser/functions.g:3:1: stat : NAME ( expr )+ ;
    public final void stat() throws RecognitionException {
        try {
            // /home/felipe/workspaces/examples/parsers/javaparser/functions.g:3:6: ( NAME ( expr )+ )
            // /home/felipe/workspaces/examples/parsers/javaparser/functions.g:3:8: NAME ( expr )+
            {
            match(input,NAME,FOLLOW_NAME_in_stat10); 
            // /home/felipe/workspaces/examples/parsers/javaparser/functions.g:3:13: ( expr )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==NAME||LA1_0==6) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/felipe/workspaces/examples/parsers/javaparser/functions.g:3:13: expr
            	    {
            	    pushFollow(FOLLOW_expr_in_stat12);
            	    expr();

            	    state._fsp--;


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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "stat"


    // $ANTLR start "expr"
    // /home/felipe/workspaces/examples/parsers/javaparser/functions.g:4:1: expr : ( '(' stat ')' | NAME );
    public final void expr() throws RecognitionException {
        try {
            // /home/felipe/workspaces/examples/parsers/javaparser/functions.g:4:6: ( '(' stat ')' | NAME )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==6) ) {
                alt2=1;
            }
            else if ( (LA2_0==NAME) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // /home/felipe/workspaces/examples/parsers/javaparser/functions.g:4:8: '(' stat ')'
                    {
                    match(input,6,FOLLOW_6_in_expr20); 
                    pushFollow(FOLLOW_stat_in_expr21);
                    stat();

                    state._fsp--;

                    match(input,7,FOLLOW_7_in_expr22); 

                    }
                    break;
                case 2 :
                    // /home/felipe/workspaces/examples/parsers/javaparser/functions.g:4:19: NAME
                    {
                    match(input,NAME,FOLLOW_NAME_in_expr24); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "expr"

    // Delegated rules


 

    public static final BitSet FOLLOW_NAME_in_stat10 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_expr_in_stat12 = new BitSet(new long[]{0x0000000000000052L});
    public static final BitSet FOLLOW_6_in_expr20 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_stat_in_expr21 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_7_in_expr22 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_expr24 = new BitSet(new long[]{0x0000000000000002L});

}