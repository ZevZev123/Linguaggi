grammar ExL2;

main : BIT tail 'b'      // mandatory first bit
     | BIT 'b'           // minimal string (ex. 0b)
     ;
tail : BIT tail          // a bit followed by a tail
     | '_' BIT tail      // an underscore followeb by a bit and a tail
     | BIT               // last bit of the sequence
     | '_' BIT           // last bit preceeded by an underscore
     ;

BIT : '0' | '1' ;