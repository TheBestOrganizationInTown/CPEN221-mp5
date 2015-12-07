// Generated from Grammar.g4 by ANTLR 4.4

package ca.ece.ubc.cpen221.mp5;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CATEGORY=1, RATING=2, IN=3, NAME=4, PRICE=5, OR=6, AND=7, STRING=8, TO=9, 
		RPAREN=10, LPAREN=11, WHITESPACE=12, NUMBER=13, RParen=14, LParen=15;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'"
	};
	public static final String[] ruleNames = {
		"CATEGORY", "RATING", "IN", "NAME", "PRICE", "OR", "AND", "STRING", "TO", 
		"RPAREN", "LPAREN", "WHITESPACE", "NUMBER", "RParen", "LParen"
	};


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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\21^\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\6\tG\n\t\r"+
		"\t\16\tH\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\6\rS\n\r\r\r\16\rT\3\r\3\r"+
		"\3\16\3\16\3\17\3\17\3\20\3\20\2\2\21\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21\3\2\5\b\2\"\"*+\62;^^c|~~\5"+
		"\2\13\f\17\17\"\"\3\2\63\67_\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\3!\3\2\2\2\5*\3\2\2\2\7\61\3\2\2\2\t\64\3\2\2\2\139\3\2\2\2\r"+
		"?\3\2\2\2\17B\3\2\2\2\21F\3\2\2\2\23J\3\2\2\2\25M\3\2\2\2\27O\3\2\2\2"+
		"\31R\3\2\2\2\33X\3\2\2\2\35Z\3\2\2\2\37\\\3\2\2\2!\"\7e\2\2\"#\7c\2\2"+
		"#$\7v\2\2$%\7g\2\2%&\7i\2\2&\'\7q\2\2\'(\7t\2\2()\7{\2\2)\4\3\2\2\2*+"+
		"\7t\2\2+,\7c\2\2,-\7v\2\2-.\7k\2\2./\7p\2\2/\60\7i\2\2\60\6\3\2\2\2\61"+
		"\62\7k\2\2\62\63\7p\2\2\63\b\3\2\2\2\64\65\7p\2\2\65\66\7c\2\2\66\67\7"+
		"o\2\2\678\7g\2\28\n\3\2\2\29:\7r\2\2:;\7t\2\2;<\7k\2\2<=\7e\2\2=>\7g\2"+
		"\2>\f\3\2\2\2?@\7~\2\2@A\7~\2\2A\16\3\2\2\2BC\7(\2\2CD\7(\2\2D\20\3\2"+
		"\2\2EG\t\2\2\2FE\3\2\2\2GH\3\2\2\2HF\3\2\2\2HI\3\2\2\2I\22\3\2\2\2JK\7"+
		"\60\2\2KL\7\60\2\2L\24\3\2\2\2MN\7+\2\2N\26\3\2\2\2OP\7*\2\2P\30\3\2\2"+
		"\2QS\t\3\2\2RQ\3\2\2\2ST\3\2\2\2TR\3\2\2\2TU\3\2\2\2UV\3\2\2\2VW\b\r\2"+
		"\2W\32\3\2\2\2XY\t\4\2\2Y\34\3\2\2\2Z[\5\25\13\2[\36\3\2\2\2\\]\5\27\f"+
		"\2] \3\2\2\2\5\2HT\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}