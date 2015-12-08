package ca.ece.ubc.cpen221.mp5;

import java.util.Stack;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import ca.ece.ubc.cpen221.mp5.FormulaParser.AtomContext;
import ca.ece.ubc.cpen221.mp5.FormulaParser.InContext;
import ca.ece.ubc.cpen221.mp5.FormulaParser.NameContext;

public class FormulaFactory {
    
    /**
     * @param string must contain a well-formed formula string of boolean literals and operators..
     * @return Formula corresponding to the string
     */
    public static ParseTree parse(String string) {
        // Create a stream of tokens using the lexer.
        CharStream stream = new ANTLRInputStream(string);
        FormulaLexer lexer = new FormulaLexer(stream);
        lexer.reportErrorsAsExceptions();
        TokenStream tokens = new CommonTokenStream(lexer);
        
        // Feed the tokens into the parser.
        FormulaParser parser = new FormulaParser(tokens);
        parser.reportErrorsAsExceptions();
        
        // Generate the parse tree using the starter rule.
        ParseTree tree = parser.orExpr(); // "root" is the starter rule.
        
        // debugging option #1: print the tree to the console
        //System.err.println(tree.toStringTree(parser));

        // debugging option #2: show the tree in a window
        //((RuleContext)tree).inspect(parser);

        // debugging option #3: walk the tree with a listener
       // new ParseTreeWalker().walk(new FormulaListener_PrintEverything(), tree);
        
        // Finally, construct a Document value by walking over the parse tree.
       // ParseTreeWalker walker = new ParseTreeWalker();
       // FormulaListener_FormulaCreator listener = new FormulaListener_FormulaCreator();
       // walker.walk(listener, tree);
        
        // return the Document value that the listener created
        return tree;
    }
} 
   