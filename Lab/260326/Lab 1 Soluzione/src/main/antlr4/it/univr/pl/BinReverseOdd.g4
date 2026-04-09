grammar BinReverseOdd;

main : rev EOF ;
rev  : '1' | '0'| '0' rev '0' | '1' rev '1' ;