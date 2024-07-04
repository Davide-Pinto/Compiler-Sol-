grammar Tasm;
s : prog;

labels: LABEL (',' LABEL)*;

prog:
     (
     (labels ':')? stmt NEWLINE
     | NEWLINE
     )+
     EOF;

stmt    :
         ICONST INT                 #Iconst
        | DCONST DOUBLE             #Dconst
        | SCONST STRING             #Sconst
        | JUMP LABEL                #Jump
        | JUMPT LABEL               #Jumpt
        | JUMPF LABEL               #Jumpf
        | GALLOC INT                #Galloc
        | GLOAD INT                 #Gload
        | GSTORE INT                #Gstore
        | IPRINT                    #IPrint
        | IUMINUS                   #Iuminus
        | IADD                      #IAdd
        | ISUB                      #ISub
        | ILT                       #Ilt
        | IMULT                     #IMult
        | IDIV                      #IDiv
        | IMOD                      #IMod
        | IEQ                       #IEq
        | INEQ                      #INeq
        | ILEQ                      #ILeq
        | ITOD                      #ITod
        | ITOS                      #ITos
        | DPRINT                    #DPrint
        | DUMINUS                   #Duminus
        | DADD                      #DAdd
        | DSUB                      #DSub
        | DMULT                     #DMult
        | DDIV                      #DDiv
        | DEQ                       #DEq
        | DNEQ                      #DNeq
        | DLT                       #Dlt
        | DLEQ                      #Dleq
        | DTOS                      #Dtos
        | SPRINT                    #SPrint
        | SADD                      #SAdd
        | SEQ                       #Seq
        | SNEQ                      #SNeq
        | BEQ                       #Beq
        | BNEQ                      #Bneq
        | BTOS                      #Btos
        | AND                       #And
        | OR                        #Or
        | NOT                       #Not
        | TCONST                    #Tconst
        | FCONST                    #Fconst
        | BPRINT                    #Bprint
        | HALT                      #Halt
        | LALLOC  INT               #Lalloc
        | LLOAD   INT               #Lload
        | LSTORE  INT               #Lstore
        | POP     INT               #Pop
        | CALL    LABEL             #Call
        | RETVAL  INT               #Retval
        | RET     INT               #Ret
        ;

//local Storage
LALLOC: 'lalloc';
LLOAD: 'lload';
LSTORE: 'lstore';
POP: 'pop';
CALL: 'call';
RETVAL: 'retval';
RET: 'ret';

//Operators for type INT
IMULT: 'imult';
IADD : 'iadd';
IDIV: 'idiv';
ISUB: 'isub';
IUMINUS: 'iuminus';
IMOD: 'imod';
IEQ: 'ieq';
INEQ: 'ineq';
ILT: 'ilt';
ILEQ: 'ileq';
ITOD: 'itod';
ITOS: 'itos';

//Operators for type Double
DUMINUS: 'duminus';
DADD: 'dadd';
DSUB: 'dsub';
DMULT: 'dmult';
DDIV: 'ddiv';
DEQ: 'deq';
DNEQ: 'dneq';
DLT: 'dlt';
DLEQ: 'dleq';
DTOS: 'dtos';

//Operators for type Boolean

BEQ: 'beq';
BNEQ: 'bneq';
BTOS: 'btos';
AND: 'and';
OR: 'or';
NOT: 'not';

//Operators for type String
SADD: 'sadd';
SEQ: 'seq';
SNEQ: 'sneq';

//Instructions with argments
ICONST:'iconst';
DCONST:'dconst';
SCONST:'sconst';
JUMP: 'jump' ;
JUMPT: 'jumpt';
JUMPF: 'jumpf';
GALLOC:'galloc';
GLOAD:'gload';
GSTORE:'gstore';

//Instructions without argments
IPRINT: 'iprint';
DPRINT: 'dprint';
SPRINT: 'sprint';
BPRINT: 'bprint';
TCONST: 'tconst';
FCONST: 'fconst';
HALT: 'halt';

//Support staff
DOUBLE: DIGIT+ '.' DIGIT* | '.' DIGIT+ ;
INT: ('-')?DIGIT+;
QM:'"';
STRING: '"' (ESC | ~["\\])* '"';

COLON: ':';
NEWLINE: '\r'? '\n' ;
WS : [ \t]+ -> skip ;
LABEL: LETTER (LETTER | DIGIT)*;

//Fragments
fragment
DIGIT : [0-9];

fragment
LETTER:[a-zA-Z];

fragment
ESC : '\\' . ;
