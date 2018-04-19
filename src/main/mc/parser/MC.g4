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

// Parser
program  : declList EOF;
declList: decl+;
decl: varDecl | funcDecl;

// Variable Declare
varDecl: primitiveType varList SEMI;
varList: variable (COMMA variable)*;
variable: ID | ID LS INTLIT RS;

// Primitive TYPE
primitiveType: BOOLTYPE | INTTYPE | FLOATTYPE | STRINGTYPE;

// Function Declare
funcDecl: funcType ID LB paraList RB blockStmt;
funcType: primitiveType | VOIDTYPE | outputArrPointerType;
paraList: paraListNonNull?;
paraListNonNull: paraDecl (COMMA paraDecl)*;
paraDecl: primitiveType (ID | ID LS RS);

// Array pointer TYPE
arrayPointerType: inputArrPointerType
    | outputArrPointerType;
inputArrPointerType: primitiveType ID LS RS;
outputArrPointerType: primitiveType LS RS;

// Block statement
blockStmt: LP declPart stmtPart RP;
declPart: varDecl*;
stmtPart: stmt*;

stmt: ifStmt
    | otherStmt;

otherStmt: forStmt 
    | dowhileStmt 
    | breakStmt
    | continueStmt 
    | returnStmt 
    | expStmt
    | blockStmt;

breakStmt: BREAK SEMI;
continueStmt: CONTINUE SEMI;
// Return Statement
returnStmt: noExpReturn | aExpReturn;
noExpReturn: RETURN SEMI;
aExpReturn: RETURN exp0 SEMI;
// If statement
stmtmatch: ifmatch
    | otherStmt;
stmtunmatch: ifunmatch
    | otherStmt;

ifStmt: ifmatch | ifunmatch;
ifmatch: IF LB exp0 RB stmtmatch ELSE stmtmatch;
// If statement with dangling
ifunmatch: IF LB exp0 RB stmt
         | IF LB exp0 RB stmtmatch ELSE stmtunmatch;
// Do while statement
dowhileStmt: DO stmt+ WHILE exp0 SEMI;
// For statement
forStmt: FOR LB exp0 SEMI exp0 SEMI exp0 RB stmt;
// Expression statement
expStmt: exp0 SEMI;
// Expression
exp0: exp1 ASSIGNOP exp0
    | exp1;
exp1: exp1 OROP exp2
    | exp2;
exp2: exp2 ANDOP exp3
    | exp3;
exp3: exp4 EQUALOP exp4
    | exp4 NEQUALOP exp4
    | exp4;
exp4: exp5 LTOP exp5
    | exp5 GTOP exp5
    | exp5 LTEOP exp5
    | exp5 GTEOP exp5
    | exp5;
exp5: exp5 ADDOP exp6
    | exp5 SUBOP exp6
    | exp6;
exp6: exp6 MULOP exp7
    | exp6 DIVOP exp7
    | exp6 MODOP exp7
    | exp7;
exp7: SUBOP exp7
    | NEVOP exp7
    | exp8;
exp8: LB exp0 RB
    | exp9;
exp9: indexExp
    | funcCall
    | INTLIT
    | FLOATLIT
    | STRINGLIT
    | BOOLLIT
    | ID;

indexExp: indexer LS exp0 RS;
indexer: funcCall | ID;
// Function call
funcCall: ID LB argList RB;
argList: argListNonNull?;
argListNonNull: exp0 (COMMA exp0)*;
// Lexer
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
fragment DIGITS: [0-9];
// -- Float literal
fragment EXP: [eE]('-')?DIGITS+;
fragment FRACTION: (DIGITS+'.'DIGITS*) | (DIGITS*'.'DIGITS+);
FLOATLIT: (FRACTION)(EXP)? | (DIGITS+EXP);
// -- Int literal
INTLIT: DIGITS+;
// -- String literal
fragment ESCAPE: [\b\f\r\n\t\'\"\\];
STRINGLIT: '"'('\\'[bfrnt'"\\] | ~[\b\f\r\n\t\'\"\\])*'"' {setText(getText().substring(1, getText().length()-1));};

// ID: catch after keywords, literal
ID: [a-zA-Z_][a-zA-Z0-9_]* ;

LB: '(' ;
RB: ')' ;
LP: '{';
RP: '}';
LS: '[';
RS: ']';
SEMI: ';' ;
COMMA: ',';

// Operator
NEVOP: '!';
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

ILLEGAL_ESCAPE: '"'('\\'[bfrnt'"\\] | ~[\b\f\r\n\t\'\"\\])* [\b\f\r\n\t\'\"\\] {setText(getText().substring(1, getText().length() - 1));};
UNCLOSE_STRING: '"'('\\'[bfrnt'"\\] | ~[\b\f\r\n\t\'\"\\])+ {setText(getText().substring(1, getText().length()));};
ERROR_CHAR: .;