grammar ExL1;

main : s EOF ;
s    : x O x O x O x O x ;
x    : Z x | O x | ;

Z : '0' ;
O : '1' ;