/**
 * Student name: Ho Quang Thanh
 * Student ID: 1413494
 */
grammar MC;

@lexer::header{
	package mc.parser;
}

@lexer::members{
@Override
public Token emit() {
    switch (getType()) {
    case UNCLOSE_STRING:       
        Token result = super.emit();
        // you'll need to define this method
        throw new UncloseString(result.getText());
        
    case ILLEGAL_ESCAPE:
    	result = super.emit();
    	throw new IllegalEscape(result.getText());

    case ERROR_CHAR:
    	result = super.emit();
    	throw new ErrorToken(result.getText());	

    default:
        return super.emit();
    }
}
}

@parser::header{
	package mc.parser;
}

options{
	language=Java;
}

program  : .;

// Comments
BLOCKCMT: '/*'.*?'*/' -> skip;
LINECMT: '//'(~[\n\r])* -> skip;
// skip spaces, tabs, newlines
WS : [ \t\r\n]+ -> skip ; 

// Data types
INTTYPE: 'int' ;
BOOLTYPE: 'boolean';
FLOATTYPE: 'float';
STRINGTYPE: 'string';
VOIDTYPE: 'void' ;

// Keywords
TRUE: 'true';
FALSE: 'false';

// ID: catch after keywords
ID: [a-zA-Z]+ ;

// Literals
// -- Boolean literal: contain 2 keywords
BOOLLIT: TRUE | FALSE;
// -- Int literal
INTLIT: [0-9]+;
// -- Float literal
// FLOATLIT: ;
// -- String literal
fragment ESCAPE: [\b\f\r\n\t\'\"\\];
STRINGLIT: '"'('\\'[bfrnt'"\\] | ~[\b\f\r\n\t\'\"\\])*'"';

LB: '(' ;
RB: ')' ;
LP: '{';
RP: '}';
LS: '[';
RS: ']';
SEMI: ';' ;

// Operator
DIVOP: '/';
MULOP: '*';
MODOP: '%';
PLUSOP: '+';
//MINUS: '';
LTOP: '<';
LTEOP: '<=';
GTOP: '>';
GTEOP: '>=';
EQUALOP: '==';
DIFOP: '!=';
ANDOP: '&&';
OROP: '||';
ASSIGNOP: '=';

ERROR_CHAR: .;
UNCLOSE_STRING: .;
ILLEGAL_ESCAPE: .;
