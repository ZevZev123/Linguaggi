grammar BinWords;

// terminatore di stringa (dopo bin finisce)
main : bin EOF ;

// match la stringa vuota, 0S e 1S
// apici per simbolo terminale
bin : | '0' bin | '1' bin ;

// parser
