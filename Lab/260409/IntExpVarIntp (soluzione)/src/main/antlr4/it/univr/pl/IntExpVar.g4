grammar IntExpVar;

main : prog EOF ;

prog : init exp ;

init : ID EQUAL exp SEMICOLON init  # idinit
     |                              # nilinit
     ;

exp : VAL                       # val
    | ID                        # id
    | LPAR exp ADD exp RPAR     # add
    | LPAR exp MUL exp RPAR     # mul
    | LPAR exp SUB exp RPAR     # sub
    | LPAR exp DIV exp RPAR     # div
    | LPAR exp MOD exp RPAR     # mod
    ;

LPAR      : '('   ;
RPAR      : ')'   ;
ADD       : '+'   ;
MUL       : '*'   ;
SUB       : '-'   ;
DIV       : '/'   ;
MOD       : 'mod' ;
EQUAL     : '='   ;
SEMICOLON : ';'   ;

ID : [a-z]+ ;

VAL : NAT | NEG ;
NAT : '0' | [1-9][0-9]* ;
NEG : '-' [1-9][0-9]* ;

WS : [ \t\n\r]+ -> skip ;