grammar Sol;
s : prog;

prog: declaration* functionDeclaration+;

stmt:
      PRINT expr STMT_T                                   #Print
    | VARNAME '=' expr STMT_T                             #VarChange
    | block                                               #Blocks
    | WHILE expr DO stmt                                  #While
    | FOR VARNAME '=' expr TO expr DO stmt                #For
    | IF expr THEN stmt (ELSE stmt)?                      #IfElse
    | BREAK STMT_T                                        #Break
    | STMT_T                                              #Empty
    | VARNAME LPARE (expr (',' expr)*)? RPARE STMT_T      #CallStmt
    | RETURN expr? STMT_T                                 #Return
    ;

declaration:
      typeSpecifier varDeclaration (',' varDeclaration)* STMT_T;

varDeclaration:
      VARNAME ('=' expr)?;


functionDeclaration:
    typeSpecifier VARNAME LPARE formalParameters? RPARE block;


//Arguments
formalParameters:
    formalParameter (',' formalParameter)*;

formalParameter:
    typeSpecifier VARNAME;

block:
    BEGIN declaration* stmt* END;


typeSpecifier:
      K_INT
    | K_REAL
    | K_BOOL
    | K_STRING
    | K_VOID
    ;

expr:
     INT                                    #Int
    |DOUBLE                                 #Double
    |STRING                                 #String
    |BOOL                                   #Bool
    |VARNAME                                #Var
    |LPARE expr RPARE                       #Parentheses
    |MINUS expr                             #Minus
    |NOT expr                               #Not
    |<assoc=right> expr MULT expr           #Mult
    |<assoc=right> expr DIV expr            #Div
    |<assoc=right> expr MOD expr            #Mod
    |expr ADD expr                          #Add
    |expr MINUS expr                        #Sub
    |expr LTHAN expr                        #Lthan
    |expr BTHAN expr                        #Bthan
    |expr LETHAN expr                       #Lethan
    |expr BETHAN expr                       #Bethan
    |expr EQUALS expr                       #Equals
    |expr NOTEQUALS expr                    #Notequals
    |expr AND expr                          #And
    |expr OR expr                           #Or
    |VARNAME LPARE (expr (',' expr)*)? RPARE   #CallExpr
    ;

//Reserved words/Statements
RETURN: 'return';
BEGIN: 'begin';
END: 'end';
WHILE: 'while';
DO: 'do';
FOR: 'for';
TO: 'to';
IF: 'if';
THEN: 'then';
ELSE: 'else';
BREAK: 'break';
K_INT: 'int';
K_BOOL: 'bool';
K_REAL: 'real';
K_STRING: 'string';
K_VOID: 'void';
PRINT: 'print';

//Parentheses
LPARE: '(';
RPARE: ')';
//Unary
MINUS: '-';
NOT: 'not';

//Operators
MULT: '*';
DIV: '/';
MOD: '%';
ADD: '+';
//Relational
LTHAN: '<';     //Less Than
BTHAN: '>';     //Bigger Than
LETHAN: '<=';   //Less or Equan Than
BETHAN: '>=';   //Bigger or Equan Than
//equality and inequality
EQUALS: '==';
NOTEQUALS: '!=';
//Logic
AND: 'and';
OR: 'or';



//Support staff
DOUBLE: DIGIT+ '.' DIGIT* | '.' DIGIT+ ;
INT: DIGIT+;
BOOL: ('true'|'false');
VARNAME : (LETTER|UNS) (LETTER|DIGIT|UNS)*;
QM:'"';
UNS:'_';
STMT_T: ';';
STRING: QM (ESC | ~["\\])* QM;

WS : [ \t\n\r]+ -> skip ;
SL_COMMENT : '//' .*? (EOF|'\n') -> skip; // single-line comment
ML_COMMENT : '/*' .*? '*/' -> skip ; // multi-line comment


//Fragments
fragment
DIGIT : [0-9] ;

fragment
LETTER:[a-zA-Z];

fragment
ESC : '\\' . ;