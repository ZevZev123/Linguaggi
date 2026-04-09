grammar RecDigList;

main : list EOF ;
list : LPAR RPAR | LPAR dig tail RPAR ;
dig  : '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9' | list ;
tail : | COMMA dig tail ;

LPAR  : '(' ;
RPAR  : ')' ;
COMMA : ',' ;