grammar functions;

// START: parser
stat	:	NAME params;
params	:	expr+;
expr	:	'('stat')'| NAME;
// END: parser

// START: lexer
NAME	:	LETTER+;
LETTER	:	'a'..'z'|'A'..'Z';
WS	:	(' '|'\t'|'\n'|'\r')+ {skip();};
// END: lexer