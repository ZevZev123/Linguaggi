grammar DecExpVar;

main : prog EOF ;

prog : init exp ;

init : (ID EQUAL exp SEMICOLON)* ;

exp : VAL                            # val
    | ID                             # id
    | <assoc=right> exp POW exp      # pow
    | exp op=(MUL | DIV | MOD) exp   # mulDivMod
    | exp op=(ADD | SUB) exp         # addSub
    | LPAR exp RPAR                  # parExp
    ;

LPAR      : '('   ;
RPAR      : ')'   ;
ADD       : '+'   ;
MUL       : '*'   ;
SUB       : '-'   ;
DIV       : '/'   ;
MOD       : 'mod' ;
POW       : '^'   ;
EQUAL     : '='   ;
SEMICOLON : ';'   ;

ID : [a-z]+ ;

VAL               : INT | (INT | '-' '0') '.' DIGIT+ ;
fragment INT      : NAT | '-' POS                    ;
fragment NAT      : '0' | POS                        ;
fragment POS      : POSDIGIT DIGIT*                  ;
fragment DIGIT    : '0' | POSDIGIT                   ;
fragment POSDIGIT : [1-9]                            ;

COMMENT: '<!--' ~[\r\n]* -> skip;

WS : [ \t\n\r]+ -> skip ;
