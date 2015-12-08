grammar Formula;

// This puts "package ca.ece.ubc.cpen221.mp5;" at the top of the output Java files.
@header {
package ca.ece.ubc.cpen221.mp5;
}

// This adds code to the generated lexer and parser. Do not change these lines.
@members {
    // This method makes the lexer or parser stop running if it encounters
    // invalid input and throw a RuntimeException.
    public void reportErrorsAsExceptions() {
        //removeErrorListeners();
        
        addErrorListener(new ExceptionThrowingErrorListener());
    }
    
    private static class ExceptionThrowingErrorListener extends BaseErrorListener {
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer,
                Object offendingSymbol, int line, int charPositionInLine,
                String msg, RecognitionException e) {
            throw new RuntimeException(msg);
        }
    }
}

/*
 * These are the lexical rules. They define the tokens used by the lexer.
 *   *** Antlr requires tokens to be CAPITALIZED, like START_ITALIC, END_ITALIC, and TEXT.
 */

CATEGORY : 'category' ;
RATING : 'rating' ;
IN : 'in' ;
NAME : 'name' ;
PRICE : 'price' ; 
OR: '||';
AND : '&&';
STRING : [a-z | (\ u 0 0 e 9) | 0-9]+ ;
TO : '..' ;
RPAREN : ')';
LPAREN : '(';
WHITESPACE : [ \t\r\n]+ -> skip ;
NUMBER : [1-5] ; 

/*
 * These are the parser rules. They define the structures used by the parser.
 *    *** Antlr requires grammar nonterminals to be lowercase, like html, normal, and italic.
 *  <orExpr> ::= <andExpr>(<or><andExpr>)*
* <andExpr> ::= <atom>(<and><atom>)*
* <atom> ::= <in>|<category>|<rating>|<price>|<name>|<LParen><orExpr><RParen>
* <or> ::= "||"
* <and> ::= "&&"
* <in> ::= "in" <LParen><string><RParen>
* <category> ::= "category" <LParen><string><RParen>
* <name> ::= "name" <LParen><string><RParen>
* <rating> ::= "rating" <LParen><range><RParen>
* <price> ::= "price" <LParen><range><RParen>
* <range> ::= [1-5]..[1-5]
* <LParen> ::= "("
* <RParen> ::= ")"
 */

orExpr : andExpr (OR andExpr)* EOF;
andExpr : atom (AND atom)* ; 
atom : in | category | rating | price | name | LParen orExpr RParen ; 
in : IN LParen STRING RParen ; 
category : CATEGORY LParen STRING RParen ; 
name : NAME LParen STRING RParen ; 
rating : RATING LParen range RParen ;
price : PRICE LParen range RParen ;
 range : NUMBER TO NUMBER ;
 RParen : RPAREN ;
 LParen : LPAREN ;
