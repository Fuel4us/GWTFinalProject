package pt.isep.nsheets.shared.core.js;
// Generated from Js.g4 by ANTLR 4.2.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JsLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, OR=2, AND=3, EQ=4, NEQ=5, GT=6, LT=7, GTEQ=8, LTEQ=9, PLUS=10, 
		MINUS=11, MULT=12, DIV=13, MOD=14, NOT=15, POW=16, COMMA=17, SCOL=18, 
		ASSIGN=19, OPAR=20, CPAR=21, OBRACE=22, CBRACE=23, TRUE=24, FALSE=25, 
		NIL=26, IF=27, ELSE=28, WHILE=29, LOG=30, ID=31, INT=32, FLOAT=33, STRING=34, 
		COMMENT=35, SPACE=36, OTHER=37;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'var'", "'||'", "'&&'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='", 
		"'+'", "'-'", "'*'", "'/'", "'%'", "'!'", "'Math.pow'", "','", "';'", 
		"'='", "'('", "')'", "'{'", "'}'", "'true'", "'false'", "'null'", "'if'", 
		"'else'", "'while'", "'console.log'", "ID", "INT", "FLOAT", "STRING", 
		"COMMENT", "SPACE", "OTHER"
	};
	public static final String[] ruleNames = {
		"T__0", "OR", "AND", "EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", "PLUS", 
		"MINUS", "MULT", "DIV", "MOD", "NOT", "POW", "COMMA", "SCOL", "ASSIGN", 
		"OPAR", "CPAR", "OBRACE", "CBRACE", "TRUE", "FALSE", "NIL", "IF", "ELSE", 
		"WHILE", "LOG", "ID", "INT", "FLOAT", "STRING", "COMMENT", "SPACE", "OTHER"
	};


	public JsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Js.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\'\u00f3\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35"+
		"\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3 \5 \u00b6\n \3 \3 \7 \u00ba\n \f \16"+
		" \u00bd\13 \3!\6!\u00c0\n!\r!\16!\u00c1\3\"\6\"\u00c5\n\"\r\"\16\"\u00c6"+
		"\3\"\3\"\7\"\u00cb\n\"\f\"\16\"\u00ce\13\"\3\"\3\"\6\"\u00d2\n\"\r\"\16"+
		"\"\u00d3\5\"\u00d6\n\"\3#\3#\3#\3#\7#\u00dc\n#\f#\16#\u00df\13#\3#\3#"+
		"\3$\3$\3$\3$\7$\u00e7\n$\f$\16$\u00ea\13$\3$\3$\3%\3%\3%\3%\3&\3&\2\2"+
		"\'\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37"+
		"= ?!A\"C#E$G%I&K\'\3\2\b\5\2C\\aac|\6\2\62;C\\aac|\3\2\62;\5\2\f\f\17"+
		"\17$$\4\2\f\f\17\17\5\2\13\f\17\17\"\"\u00fc\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\3"+
		"M\3\2\2\2\5Q\3\2\2\2\7T\3\2\2\2\tW\3\2\2\2\13Z\3\2\2\2\r]\3\2\2\2\17_"+
		"\3\2\2\2\21a\3\2\2\2\23d\3\2\2\2\25g\3\2\2\2\27i\3\2\2\2\31k\3\2\2\2\33"+
		"m\3\2\2\2\35o\3\2\2\2\37q\3\2\2\2!s\3\2\2\2#|\3\2\2\2%~\3\2\2\2\'\u0080"+
		"\3\2\2\2)\u0082\3\2\2\2+\u0084\3\2\2\2-\u0086\3\2\2\2/\u0088\3\2\2\2\61"+
		"\u008a\3\2\2\2\63\u008f\3\2\2\2\65\u0095\3\2\2\2\67\u009a\3\2\2\29\u009d"+
		"\3\2\2\2;\u00a2\3\2\2\2=\u00a8\3\2\2\2?\u00b5\3\2\2\2A\u00bf\3\2\2\2C"+
		"\u00d5\3\2\2\2E\u00d7\3\2\2\2G\u00e2\3\2\2\2I\u00ed\3\2\2\2K\u00f1\3\2"+
		"\2\2MN\7x\2\2NO\7c\2\2OP\7t\2\2P\4\3\2\2\2QR\7~\2\2RS\7~\2\2S\6\3\2\2"+
		"\2TU\7(\2\2UV\7(\2\2V\b\3\2\2\2WX\7?\2\2XY\7?\2\2Y\n\3\2\2\2Z[\7#\2\2"+
		"[\\\7?\2\2\\\f\3\2\2\2]^\7@\2\2^\16\3\2\2\2_`\7>\2\2`\20\3\2\2\2ab\7@"+
		"\2\2bc\7?\2\2c\22\3\2\2\2de\7>\2\2ef\7?\2\2f\24\3\2\2\2gh\7-\2\2h\26\3"+
		"\2\2\2ij\7/\2\2j\30\3\2\2\2kl\7,\2\2l\32\3\2\2\2mn\7\61\2\2n\34\3\2\2"+
		"\2op\7\'\2\2p\36\3\2\2\2qr\7#\2\2r \3\2\2\2st\7O\2\2tu\7c\2\2uv\7v\2\2"+
		"vw\7j\2\2wx\7\60\2\2xy\7r\2\2yz\7q\2\2z{\7y\2\2{\"\3\2\2\2|}\7.\2\2}$"+
		"\3\2\2\2~\177\7=\2\2\177&\3\2\2\2\u0080\u0081\7?\2\2\u0081(\3\2\2\2\u0082"+
		"\u0083\7*\2\2\u0083*\3\2\2\2\u0084\u0085\7+\2\2\u0085,\3\2\2\2\u0086\u0087"+
		"\7}\2\2\u0087.\3\2\2\2\u0088\u0089\7\177\2\2\u0089\60\3\2\2\2\u008a\u008b"+
		"\7v\2\2\u008b\u008c\7t\2\2\u008c\u008d\7w\2\2\u008d\u008e\7g\2\2\u008e"+
		"\62\3\2\2\2\u008f\u0090\7h\2\2\u0090\u0091\7c\2\2\u0091\u0092\7n\2\2\u0092"+
		"\u0093\7u\2\2\u0093\u0094\7g\2\2\u0094\64\3\2\2\2\u0095\u0096\7p\2\2\u0096"+
		"\u0097\7w\2\2\u0097\u0098\7n\2\2\u0098\u0099\7n\2\2\u0099\66\3\2\2\2\u009a"+
		"\u009b\7k\2\2\u009b\u009c\7h\2\2\u009c8\3\2\2\2\u009d\u009e\7g\2\2\u009e"+
		"\u009f\7n\2\2\u009f\u00a0\7u\2\2\u00a0\u00a1\7g\2\2\u00a1:\3\2\2\2\u00a2"+
		"\u00a3\7y\2\2\u00a3\u00a4\7j\2\2\u00a4\u00a5\7k\2\2\u00a5\u00a6\7n\2\2"+
		"\u00a6\u00a7\7g\2\2\u00a7<\3\2\2\2\u00a8\u00a9\7e\2\2\u00a9\u00aa\7q\2"+
		"\2\u00aa\u00ab\7p\2\2\u00ab\u00ac\7u\2\2\u00ac\u00ad\7q\2\2\u00ad\u00ae"+
		"\7n\2\2\u00ae\u00af\7g\2\2\u00af\u00b0\7\60\2\2\u00b0\u00b1\7n\2\2\u00b1"+
		"\u00b2\7q\2\2\u00b2\u00b3\7i\2\2\u00b3>\3\2\2\2\u00b4\u00b6\7&\2\2\u00b5"+
		"\u00b4\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00bb\t\2"+
		"\2\2\u00b8\u00ba\t\3\2\2\u00b9\u00b8\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb"+
		"\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc@\3\2\2\2\u00bd\u00bb\3\2\2\2"+
		"\u00be\u00c0\t\4\2\2\u00bf\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00bf"+
		"\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2B\3\2\2\2\u00c3\u00c5\t\4\2\2\u00c4"+
		"\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2"+
		"\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00cc\7\60\2\2\u00c9\u00cb\t\4\2\2\u00ca"+
		"\u00c9\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2"+
		"\2\2\u00cd\u00d6\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d1\7\60\2\2\u00d0"+
		"\u00d2\t\4\2\2\u00d1\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d1\3\2"+
		"\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d6\3\2\2\2\u00d5\u00c4\3\2\2\2\u00d5"+
		"\u00cf\3\2\2\2\u00d6D\3\2\2\2\u00d7\u00dd\7$\2\2\u00d8\u00dc\n\5\2\2\u00d9"+
		"\u00da\7$\2\2\u00da\u00dc\7$\2\2\u00db\u00d8\3\2\2\2\u00db\u00d9\3\2\2"+
		"\2\u00dc\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00e0"+
		"\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e1\7$\2\2\u00e1F\3\2\2\2\u00e2\u00e3"+
		"\7\61\2\2\u00e3\u00e4\7\61\2\2\u00e4\u00e8\3\2\2\2\u00e5\u00e7\n\6\2\2"+
		"\u00e6\u00e5\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9"+
		"\3\2\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb\u00ec\b$\2\2\u00ec"+
		"H\3\2\2\2\u00ed\u00ee\t\7\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\b%\2\2\u00f0"+
		"J\3\2\2\2\u00f1\u00f2\13\2\2\2\u00f2L\3\2\2\2\r\2\u00b5\u00bb\u00c1\u00c6"+
		"\u00cc\u00d3\u00d5\u00db\u00dd\u00e8\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}