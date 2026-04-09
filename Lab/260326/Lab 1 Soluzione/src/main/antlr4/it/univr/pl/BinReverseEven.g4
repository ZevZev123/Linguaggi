grammar BinReverseEven;

main : rev EOF ;
rev  : | '0' rev '0' | '1' rev '1' ;