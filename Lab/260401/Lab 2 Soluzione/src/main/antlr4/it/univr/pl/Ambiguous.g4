grammar Ambiguous;
import Nat;

main : VAR ' ' ID EOF ;
VAR  : 'var' ; // correct order
ID   : [a-z]+ ;

/*
test    : FOR EACH; // never called rule
FOR     : 'for';
EACH    : 'each';
FOREACH : 'foreach';
*/

/*
test : exp EOF;
exp : nat | exp ADD exp | exp MUL exp ; // precedence to ADD
ADD : '+' ;
MUL : '*' ;
*/