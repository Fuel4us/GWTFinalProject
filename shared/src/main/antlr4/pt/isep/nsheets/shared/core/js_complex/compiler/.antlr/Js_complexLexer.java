// Generated from /Users/pedromonteiro/Desktop/REPO/shared/src/main/antlr4/pt/isep/nsheets/shared/core/js_complex/compiler/Js_complex.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Js_complexLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, OR=2, AND=3, EQ=4, NEQ=5, GT=6, LT=7, GTEQ=8, LTEQ=9, PLUS=10, 
		MINUS=11, MULT=12, DIV=13, MOD=14, NOT=15, POW=16, COMMA=17, SCOL=18, 
		ASSIGN=19, OPAR=20, CPAR=21, OBRACE=22, CBRACE=23, TRUE=24, FALSE=25, 
		NIL=26, IF=27, ELSE=28, WHILE=29, LOG=30, FDECLARATION=31, RETURN=32, 
		ID=33, INT=34, FLOAT=35, STRING=36, COMMENT=37, SPACE=38, OTHER=39;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "OR", "AND", "EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", "PLUS", 
		"MINUS", "MULT", "DIV", "MOD", "NOT", "POW", "COMMA", "SCOL", "ASSIGN", 
		"OPAR", "CPAR", "OBRACE", "CBRACE", "TRUE", "FALSE", "NIL", "IF", "ELSE", 
		"WHILE", "LOG", "FDECLARATION", "RETURN", "ID", "INT", "FLOAT", "STRING", 
		"COMMENT", "SPACE", "OTHER"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'var'", "'||'", "'&&'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='", 
		"'+'", "'-'", "'*'", "'/'", "'%'", "'!'", "'Math.pow'", "','", "';'", 
		"'='", "'('", "')'", "'{'", "'}'", "'true'", "'false'", "'null'", "'if'", 
		"'else'", "'while'", "'console.log'", "'function'", "'return'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "OR", "AND", "EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", "PLUS", 
		"MINUS", "MULT", "DIV", "MOD", "NOT", "POW", "COMMA", "SCOL", "ASSIGN", 
		"OPAR", "CPAR", "OBRACE", "CBRACE", "TRUE", "FALSE", "NIL", "IF", "ELSE", 
		"WHILE", "LOG", "FDECLARATION", "RETURN", "ID", "INT", "FLOAT", "STRING", 
		"COMMENT", "SPACE", "OTHER"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public Js_complexLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Js_complex.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 29:
			LOG_action((RuleContext)_localctx, actionIndex);
			break;
		case 30:
			FDECLARATION_action((RuleContext)_localctx, actionIndex);
			break;
		case 31:
			RETURN_action((RuleContext)_localctx, actionIndex);
			break;
		case 32:
			ID_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void LOG_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			System.out.println("log RECONIZED");
			break;
		}
	}
	private void FDECLARATION_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			System.out.println("function wrote");
			break;
		}
	}
	private void RETURN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			System.out.println("return wrote");
			break;
		}
	}
	private void ID_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			System.out.println("ID RECONIZED");
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2)\u010f\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24"+
		"\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\3\31"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34"+
		"\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3"+
		" \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\5\"\u00d0\n\"\3\"\3"+
		"\"\7\"\u00d4\n\"\f\"\16\"\u00d7\13\"\3\"\3\"\3#\6#\u00dc\n#\r#\16#\u00dd"+
		"\3$\6$\u00e1\n$\r$\16$\u00e2\3$\3$\7$\u00e7\n$\f$\16$\u00ea\13$\3$\3$"+
		"\6$\u00ee\n$\r$\16$\u00ef\5$\u00f2\n$\3%\3%\3%\3%\7%\u00f8\n%\f%\16%\u00fb"+
		"\13%\3%\3%\3&\3&\3&\3&\7&\u0103\n&\f&\16&\u0106\13&\3&\3&\3\'\3\'\3\'"+
		"\3\'\3(\3(\2\2)\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)\3\2\b\5\2C\\aac|\6\2\62;C\\aa"+
		"c|\3\2\62;\5\2\f\f\17\17$$\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u0118\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2"+
		"\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2"+
		"\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\3Q\3\2\2\2\5U\3\2\2\2\7X"+
		"\3\2\2\2\t[\3\2\2\2\13^\3\2\2\2\ra\3\2\2\2\17c\3\2\2\2\21e\3\2\2\2\23"+
		"h\3\2\2\2\25k\3\2\2\2\27m\3\2\2\2\31o\3\2\2\2\33q\3\2\2\2\35s\3\2\2\2"+
		"\37u\3\2\2\2!w\3\2\2\2#\u0080\3\2\2\2%\u0082\3\2\2\2\'\u0084\3\2\2\2)"+
		"\u0086\3\2\2\2+\u0088\3\2\2\2-\u008a\3\2\2\2/\u008c\3\2\2\2\61\u008e\3"+
		"\2\2\2\63\u0093\3\2\2\2\65\u0099\3\2\2\2\67\u009e\3\2\2\29\u00a1\3\2\2"+
		"\2;\u00a6\3\2\2\2=\u00ac\3\2\2\2?\u00ba\3\2\2\2A\u00c5\3\2\2\2C\u00cf"+
		"\3\2\2\2E\u00db\3\2\2\2G\u00f1\3\2\2\2I\u00f3\3\2\2\2K\u00fe\3\2\2\2M"+
		"\u0109\3\2\2\2O\u010d\3\2\2\2QR\7x\2\2RS\7c\2\2ST\7t\2\2T\4\3\2\2\2UV"+
		"\7~\2\2VW\7~\2\2W\6\3\2\2\2XY\7(\2\2YZ\7(\2\2Z\b\3\2\2\2[\\\7?\2\2\\]"+
		"\7?\2\2]\n\3\2\2\2^_\7#\2\2_`\7?\2\2`\f\3\2\2\2ab\7@\2\2b\16\3\2\2\2c"+
		"d\7>\2\2d\20\3\2\2\2ef\7@\2\2fg\7?\2\2g\22\3\2\2\2hi\7>\2\2ij\7?\2\2j"+
		"\24\3\2\2\2kl\7-\2\2l\26\3\2\2\2mn\7/\2\2n\30\3\2\2\2op\7,\2\2p\32\3\2"+
		"\2\2qr\7\61\2\2r\34\3\2\2\2st\7\'\2\2t\36\3\2\2\2uv\7#\2\2v \3\2\2\2w"+
		"x\7O\2\2xy\7c\2\2yz\7v\2\2z{\7j\2\2{|\7\60\2\2|}\7r\2\2}~\7q\2\2~\177"+
		"\7y\2\2\177\"\3\2\2\2\u0080\u0081\7.\2\2\u0081$\3\2\2\2\u0082\u0083\7"+
		"=\2\2\u0083&\3\2\2\2\u0084\u0085\7?\2\2\u0085(\3\2\2\2\u0086\u0087\7*"+
		"\2\2\u0087*\3\2\2\2\u0088\u0089\7+\2\2\u0089,\3\2\2\2\u008a\u008b\7}\2"+
		"\2\u008b.\3\2\2\2\u008c\u008d\7\177\2\2\u008d\60\3\2\2\2\u008e\u008f\7"+
		"v\2\2\u008f\u0090\7t\2\2\u0090\u0091\7w\2\2\u0091\u0092\7g\2\2\u0092\62"+
		"\3\2\2\2\u0093\u0094\7h\2\2\u0094\u0095\7c\2\2\u0095\u0096\7n\2\2\u0096"+
		"\u0097\7u\2\2\u0097\u0098\7g\2\2\u0098\64\3\2\2\2\u0099\u009a\7p\2\2\u009a"+
		"\u009b\7w\2\2\u009b\u009c\7n\2\2\u009c\u009d\7n\2\2\u009d\66\3\2\2\2\u009e"+
		"\u009f\7k\2\2\u009f\u00a0\7h\2\2\u00a08\3\2\2\2\u00a1\u00a2\7g\2\2\u00a2"+
		"\u00a3\7n\2\2\u00a3\u00a4\7u\2\2\u00a4\u00a5\7g\2\2\u00a5:\3\2\2\2\u00a6"+
		"\u00a7\7y\2\2\u00a7\u00a8\7j\2\2\u00a8\u00a9\7k\2\2\u00a9\u00aa\7n\2\2"+
		"\u00aa\u00ab\7g\2\2\u00ab<\3\2\2\2\u00ac\u00ad\7e\2\2\u00ad\u00ae\7q\2"+
		"\2\u00ae\u00af\7p\2\2\u00af\u00b0\7u\2\2\u00b0\u00b1\7q\2\2\u00b1\u00b2"+
		"\7n\2\2\u00b2\u00b3\7g\2\2\u00b3\u00b4\7\60\2\2\u00b4\u00b5\7n\2\2\u00b5"+
		"\u00b6\7q\2\2\u00b6\u00b7\7i\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\b\37"+
		"\2\2\u00b9>\3\2\2\2\u00ba\u00bb\7h\2\2\u00bb\u00bc\7w\2\2\u00bc\u00bd"+
		"\7p\2\2\u00bd\u00be\7e\2\2\u00be\u00bf\7v\2\2\u00bf\u00c0\7k\2\2\u00c0"+
		"\u00c1\7q\2\2\u00c1\u00c2\7p\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\b \3"+
		"\2\u00c4@\3\2\2\2\u00c5\u00c6\7t\2\2\u00c6\u00c7\7g\2\2\u00c7\u00c8\7"+
		"v\2\2\u00c8\u00c9\7w\2\2\u00c9\u00ca\7t\2\2\u00ca\u00cb\7p\2\2\u00cb\u00cc"+
		"\3\2\2\2\u00cc\u00cd\b!\4\2\u00cdB\3\2\2\2\u00ce\u00d0\7&\2\2\u00cf\u00ce"+
		"\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d5\t\2\2\2\u00d2"+
		"\u00d4\t\3\2\2\u00d3\u00d2\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d3\3\2"+
		"\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d8\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8"+
		"\u00d9\b\"\5\2\u00d9D\3\2\2\2\u00da\u00dc\t\4\2\2\u00db\u00da\3\2\2\2"+
		"\u00dc\u00dd\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00deF\3"+
		"\2\2\2\u00df\u00e1\t\4\2\2\u00e0\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2"+
		"\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e8\7\60"+
		"\2\2\u00e5\u00e7\t\4\2\2\u00e6\u00e5\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8"+
		"\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00f2\3\2\2\2\u00ea\u00e8\3\2"+
		"\2\2\u00eb\u00ed\7\60\2\2\u00ec\u00ee\t\4\2\2\u00ed\u00ec\3\2\2\2\u00ee"+
		"\u00ef\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f2\3\2"+
		"\2\2\u00f1\u00e0\3\2\2\2\u00f1\u00eb\3\2\2\2\u00f2H\3\2\2\2\u00f3\u00f9"+
		"\7$\2\2\u00f4\u00f8\n\5\2\2\u00f5\u00f6\7$\2\2\u00f6\u00f8\7$\2\2\u00f7"+
		"\u00f4\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7\3\2"+
		"\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fc\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc"+
		"\u00fd\7$\2\2\u00fdJ\3\2\2\2\u00fe\u00ff\7\61\2\2\u00ff\u0100\7\61\2\2"+
		"\u0100\u0104\3\2\2\2\u0101\u0103\n\6\2\2\u0102\u0101\3\2\2\2\u0103\u0106"+
		"\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0107\3\2\2\2\u0106"+
		"\u0104\3\2\2\2\u0107\u0108\b&\6\2\u0108L\3\2\2\2\u0109\u010a\t\7\2\2\u010a"+
		"\u010b\3\2\2\2\u010b\u010c\b\'\7\2\u010cN\3\2\2\2\u010d\u010e\13\2\2\2"+
		"\u010eP\3\2\2\2\r\2\u00cf\u00d5\u00dd\u00e2\u00e8\u00ef\u00f1\u00f7\u00f9"+
		"\u0104\b\3\37\2\3 \3\3!\4\3\"\5\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}