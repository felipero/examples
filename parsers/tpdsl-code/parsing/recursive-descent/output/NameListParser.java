// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g 2010-10-20 17:17:23

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class NameListParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "LETTER", "WS", "'['", "']'", "','"
    };
    public static final int NAME=4;
    public static final int WS=6;
    public static final int LETTER=5;
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int T__8=8;
    public static final int T__7=7;

    // delegates
    // delegators


        public NameListParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public NameListParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return NameListParser.tokenNames; }
    public String getGrammarFileName() { return "/home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g"; }



    // $ANTLR start "list"
    // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:4:1: list : '[' elements ']' ;
    public final void list() throws RecognitionException {
        try {
            // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:4:10: ( '[' elements ']' )
            // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:4:12: '[' elements ']'
            {
            match(input,7,FOLLOW_7_in_list15); 
            pushFollow(FOLLOW_elements_in_list17);
            elements();

            state._fsp--;

            match(input,8,FOLLOW_8_in_list19); 

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
    // $ANTLR end "list"


    // $ANTLR start "elements"
    // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:5:1: elements : element ( ',' element )* ;
    public final void elements() throws RecognitionException {
        try {
            // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:5:10: ( element ( ',' element )* )
            // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:5:12: element ( ',' element )*
            {
            pushFollow(FOLLOW_element_in_elements35);
            element();

            state._fsp--;

            // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:5:20: ( ',' element )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==9) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:5:21: ',' element
            	    {
            	    match(input,9,FOLLOW_9_in_elements38); 
            	    pushFollow(FOLLOW_element_in_elements40);
            	    element();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
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
    // $ANTLR end "elements"


    // $ANTLR start "element"
    // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:6:1: element : ( NAME | list );
    public final void element() throws RecognitionException {
        try {
            // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:6:10: ( NAME | list )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==NAME) ) {
                alt2=1;
            }
            else if ( (LA2_0==7) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:6:12: NAME
                    {
                    match(input,NAME,FOLLOW_NAME_in_element53); 

                    }
                    break;
                case 2 :
                    // /home/felipe/workspaces/examples/parsers/tpdsl-code/parsing/recursive-descent/NameList.g:6:19: list
                    {
                    pushFollow(FOLLOW_list_in_element57);
                    list();

                    state._fsp--;


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
    // $ANTLR end "element"

    // Delegated rules


 

    public static final BitSet FOLLOW_7_in_list15 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_elements_in_list17 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_list19 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_element_in_elements35 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_9_in_elements38 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_element_in_elements40 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_NAME_in_element53 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_list_in_element57 = new BitSet(new long[]{0x0000000000000002L});

}