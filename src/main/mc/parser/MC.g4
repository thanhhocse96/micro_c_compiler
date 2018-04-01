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

program  : declList EOF;
declList: decl+;
decl: varDecl | funcDecl;
varDecl:;
funcDecl:;

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
BREAK: 'break';
CONTINUE: 'continue';
IF: 'if';
ELSE: 'else';
FOR: 'for';
RETURN: 'return';
WHILE: 'while';
DO: 'do';

// Literals
// -- Boolean literal: contain 2 keywords
BOOLLIT: TRUE | FALSE;
// Boolean Keywords
TRUE: 'true';
FALSE: 'false';
// -- Int literal
fragment DIGITS: [0-9];
INTLIT: DIGITS+;
// -- Float literal
fragment EXP: [eE]('-')?DIGITS+;
fragment FRACTION: (DIGITS+'.'DIGITS*) | (DIGITS*'.'DIGITS+);
FLOATLIT: (FRACTION)(EXP)?;
// -- String literal
fragment ESCAPE: [\b\f\r\n\t\'\"\\];
STRINGLIT: '"'('\\'[bfrnt'"\\] | ~[\b\f\r\n\t\'\"\\])*'"' {setText(getText().substring(1, getText().length()-1));};

// ID: catch after keywords, literal
ID: [a-zA-Z]+ ;

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
ADDOP: '+';
SUBOP: '-';
LTOP: '<';
LTEOP: '<=';
GTOP: '>';
GTEOP: '>=';
EQUALOP: '==';
NEQUALOP: '!=';
ANDOP: '&&';
OROP: '||';
ASSIGNOP: '=';

UNCLOSE_STRING: '"'('\\'[bfrnt'"\\] | ~[\b\f\r\n\t\'\"\\])+ {setText(getText().substring(1, getText().length()));};
ILLEGAL_ESCAPE: '"'('\\'[bfrnt'"\\] | ~[\b\f\r\n\t\'\"\\])* [\b\f\r\n\t\'\"\\] {setText(getText().substring(1, getText().length()));};
ERROR_CHAR: .;