grammar Imp;

main : com EOF ;

com : ID ASSIGN exp                           # assign
    | IF LPAR exp RPAR LBRACE com RBRACE      # if
    | WHILE LPAR exp RPAR LBRACE com RBRACE   # while
    | com SEMICOLON com                       # seq
    ;

exp : INT                                 # integer
    | BOOL                                # boolean
    | LPAR exp RPAR                       # parExp
    | <assoc=right> exp POW exp           # pow
    | NOT exp                             # not
    | exp op=(MUL | DIV | MOD) exp        # mulDivMod
    | exp op=(ADD | SUB) exp              # addSub
    | exp op=(LT | LEQ | GEQ | GT) exp    # cmpExp
    | exp op=(EQQ | NEQ) exp              # eqExp
    | exp op=(AND | OR) exp               # andOr
    | ID                                  # id
    ;

ADD : '+'   ;
SUB : '-'   ;
MUL : '*'   ;
DIV : '/'   ;
MOD : 'mod' ;
POW : '^'   ;

EQQ : '=='  ;
NEQ : '!='  ;
LEQ : '<='  ;
GEQ : '>='  ;
LT  : '<'   ;
GT  : '>'   ;
NOT : 'not' ;
AND : 'and' ;
OR  : 'or'  ;

IF     : 'if'    ;
WHILE  : 'while' ;
ASSIGN : '='     ;

LPAR      : '(' ;
RPAR      : ')' ;
LBRACE    : '{' ;
RBRACE    : '}' ;
SEMICOLON : ';' ;

BOOL : 'true' | 'false'           ;
INT  : NAT | '-' POS              ;

fragment NAT      : '0' | POS       ;
fragment POS      : POSDIGIT DIGIT* ;
fragment DIGIT    : '0' | POSDIGIT  ;
fragment POSDIGIT : [1-9]           ;

ID : [a-z]+ ;

WS : [ \t\r\n]+ -> skip ;