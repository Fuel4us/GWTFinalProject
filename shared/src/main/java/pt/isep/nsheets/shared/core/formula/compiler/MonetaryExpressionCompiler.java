/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.core.formula.compiler;

import java.text.ParseException;
import java.util.Collections;
import java.util.List;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.Tree;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.BinaryOperation;
import pt.isep.nsheets.shared.core.formula.BinaryOperator;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.Literal;
import pt.isep.nsheets.shared.core.formula.UnaryOperation;
import pt.isep.nsheets.shared.core.formula.lang.Language;
import pt.isep.nsheets.shared.core.formula.lang.LanguageManager;

/**
 *
 * @author Pedro Rodrigues - (1140572)
 */
public class MonetaryExpressionCompiler implements ExpressionCompiler {

    /**
     * The character that signals that a cell's content is a formula ('=')
     */
    public static final char FORMULA_STARTER = '#';

    private Language language = null;

    public MonetaryExpressionCompiler() {
        language = LanguageManager.getInstance().getLanguage("monetary");
    }

    @Override
    public char getStarter() {
        return FORMULA_STARTER;
    }

    @Override
    public Expression compile(Cell cell, String source) throws FormulaCompilationException {

        String number = "";
        if (source.toLowerCase().contains("dollar")) {

            double total;
            for (int i = 0; i < source.length(); i++) {

                if (source.charAt(i) == '\u20AC' || source.charAt(i) == '\u00A3' || source.charAt(i) == '\u0024') {
                    total = Double.parseDouble(number);
                    double rValue = 0;

                    if (source.charAt(i) == '\u00A3') {
                        //rValue = Conversion.PoundToDollar*total;
                    } else if (source.charAt(i) == '\u20AC') {
                        //rValue = Conversion.EuroToDollar*total;
                    } else {
                        rValue = total;
                    }

                    String stringRealValue = Double.toString(rValue);
                    i = i - number.length() + stringRealValue.length();
                    source = source.replaceFirst(number, stringRealValue);
                    number = "";
                } else if (Character.isDigit(source.charAt(i))) {
                    number += source.charAt(i);
                } else if (source.charAt(i) == '.') {
                    number += '.';
                }
            }
        } else if (source.toLowerCase().contains("pound")) {
            double total;

            for (int i = 0; i < source.length(); i++) {
                if (source.charAt(i) == '\u20AC' || source.charAt(i) == '\u00A3' || source.charAt(i) == '\u0024') {
                    total = Double.parseDouble(number);
                    double rValue = 0;

                    if (source.charAt(i) == '\u20AC') {
                        //rValue = Conversion.EuroToPound*total;
                    } else if (source.charAt(i) == '\u0024') {
                        //rValue = Conversion.DollarToPound*total;
                    } else {
                        rValue = total;
                    }

                    String stringRealValue = Double.toString(rValue);
                    i = i - number.length() + stringRealValue.length();
                    source = source.replaceFirst(number, stringRealValue);
                    number = "";
                } else if (Character.isDigit(source.charAt(i))) {
                    number += source.charAt(i);
                } else if (source.charAt(i) == '.') {
                    number += '.';
                }
            }
        } else if (source.toLowerCase().contains("euro")) {
            double total;

            for (int i = 0; i < source.length(); i++) {
                if (source.charAt(i) == '\u20AC' || source.charAt(i) == '\u00A3' || source.charAt(i) == '\u0024') {
                    total = Double.parseDouble(number);
                    double rValue = 0;

                    if (source.charAt(i) == '\u0024') {
                        //rValue = Conversion.DollarToEuro*total;
                    } else if (source.charAt(i) == '\u00A3') {
                        //rValue = Conversion.PoundToEuro*total;
                    } else {
                        rValue = total;
                    }

                    String stringRealValue = Double.toString(rValue);
                    i = i - number.length() + stringRealValue.length();
                    source = source.replaceFirst(number, stringRealValue);
                    number = "";
                } else if (Character.isDigit(source.charAt(i))) {
                    number += source.charAt(i);
                } else if (source.charAt(i) == '.') {
                    number += '.';
                }
            }
        }

        if (source.contains("{-")) {
            source = source.replaceFirst("-", "0\u20AC-");
        }

        //Creates the lexer and parser
        ANTLRInputStream input = new ANTLRInputStream(source);

        //Create the buffer of tokens between the lexer and parser
        FormulaLexer lexer = new FormulaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FormulaParser parser = new FormulaParser(tokens);

        MonetaryExpressionCompiler.FormulaErrorListener formulaErrorListener = new MonetaryExpressionCompiler.FormulaErrorListener();

        //Attempts to match an expression
        ParseTree tree = parser.expression();

        if (parser.getNumberOfSyntaxErrors() > 0) {
            throw new FormulaCompilationException(formulaErrorListener.getErrorMessage());
        }

        //Visit the expression and returns it
        FormulaEvalVisitor eval = new FormulaEvalVisitor(cell, language);
        Expression result = eval.visit(tree);

        if (eval.getNumberOfErrors() > 0) {
            throw new FormulaCompilationException(eval.getErrorsMessage());
        }

        return result;
    }

    public static class FormulaErrorListener extends BaseErrorListener {

        private StringBuilder buf;

        public String getErrorMessage() {
            return buf.toString();
        }

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer,
                Object offendingSymbol,
                int line, int charPositionInLine,
                String msg,
                RecognitionException e) {
            List<String> stack = ((Parser) recognizer).getRuleInvocationStack();
            Collections.reverse(stack);

            buf = new StringBuilder();
            buf.append("line ").append(line).append(":").append(charPositionInLine).append(": ").append(msg);
        }
    }
}