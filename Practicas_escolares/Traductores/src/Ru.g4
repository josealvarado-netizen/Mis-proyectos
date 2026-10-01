grammar Ru;

programa //Regla general del programa
 : bloque EOF //contiene un bloque seguido de un saldo de linea
 ;

bloque //regla bloque
 : sentencia*//un bloque puede llegar a conterner 0 ninguna o mas sentencias
 ;

sentencia //Regla sentencia
 : asignacion  //Regla de asignacion
 | sentencia_if //Regla if
 | sentencia_while  //Regla bucle
 | log  //
 | imprimir //Regla de impresion
 | OTRO {System.err.println("caracter desconocido: " + $OTRO.text);} // Si no reconce ningun token regresa un error
 ;

asignacion //Regla de asignacion
 : ID ASIGNA expr PTOCOMA
 // esta constituido por un ID
 // "ASIGNA" token especial
 // regla de expresion
 //"PTOCOMA" token especial
 ;

sentencia_if// regla IF
 : IF bloque_condicional (ELSE IF bloque_condicional)* (ELSE bloque_de_sentencia)?
 //"IF" caracter especial
 //regla de bloque
 //Puede llevar ningun o mas de un bloque condicial con el ELSE IF
 //
 ;

bloque_condicional // regla de bloque condicional
 : APAR expr CPAR bloque_de_sentencia
 //"APAR" token especial
 //Regla expresion
 // "CPAR" token especial
 //Regla bloque de sentencia
 ;


bloque_de_sentencia // Regla de Bloque de sentencia
 : ALLAVE bloque CLLAVE
 | sentencia
 //"ALLAVE" token especial
 //Regla de bloque
 //"CLLAVE" token especial
 //Regla de sentencia
 ;

sentencia_while //Regla while
 : WHILE expr bloque_de_sentencia
 //"While" token especial
 //regla expresion
 //regla de sentencia
 ;

log //regla log
 : LOG expr PTOCOMA
 //"LOG" token especial
 //regla expresion
 //"PTOCOMA" token especial
 ;
 
imprimir //Regla para imprimir
: IMPRIMIR expr PTOCOMA
//"IMPEIMIR" token especial
//Regla expresion
//"PTOCOMA" token especial
;

//Reglas para la expresion
expr
 : expr POW<assoc=right> expr                      #powExpr
 | MENOS expr                                      #MenosUnarioExpr
 | NOT expr                                        #notExpr
 | expr op=(MULT | DIV | MOD) expr                 #multiplicacionExpr
 | expr op=(MAS | MENOS) expr                      #aditivaExpr
 | expr op=(MAYIG | MENIG | MENORQ | MAYORQ) expr  #relacionalExpr
 | expr op=(IGUAL | DIFQ) expr                     #igualdadExpr
 | expr AND expr                                   #andExpr
 | expr OR expr                                    #orExpr
 | atomo                                            #atomExpr
 ;

//REglas atomo
atomo
 : APAR expr CPAR #parExpr
 | (INT | FLOAT)  #numberAtom
 | (TRUE | FALSE) #booleanAtom
 | ID             #idAtom
 | STRING         #stringAtom
 | NIL            #nilAtom
 ;

//Declaracion de los tokens especiales
OR : '||';
AND : '&&';
IGUAL : '==';
DIFQ : '!=';
MAYORQ : '>';
MENORQ : '<';
MENIG : '<=';
MAYIG : '>=';
MAS : '+';
MENOS : '-';
MULT : '*';
DIV : '/';
MOD : '%';
POW : '^';
NOT : '!';

PTOCOMA : ';';
ASIGNA : '=';
APAR : '(';
CPAR : ')';
ALLAVE : '{';
CLLAVE : '}';

TRUE : 'true';
FALSE : 'false';
NIL : 'nil';
IF : 'if';
ELSE : 'else';
WHILE : 'while';
LOG : 'log';

IMPRIMIR : 'imprime';

//Regla de los contenidos

ID
 : [a-zA-Z_] [a-zA-Z_0-9]*
 ;

INT
 : [0-9]+
 ;

FLOAT
 : [0-9]+ '.' [0-9]* 
 | '.' [0-9]+
 ;

STRING
 : '"' (~["\r\n] | '""')* '"'
 ;
COMENTARIO
 : '#' ~[\r\n]* -> skip
 ;
ESPACIO
 : [ \t\r\n] -> skip
 ;
OTRO
 : . 
 ;
