package pt.isep.nsheets.shared.core.js_complex;

import pt.isep.nsheets.shared.core.js.*;
import org.antlr.v4.runtime.misc.NotNull;
import pt.isep.nsheets.shared.core.vb.Value;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import pt.isep.nsheets.shared.core.js_complex.compiler.Js_complexBaseVisitor;
import pt.isep.nsheets.shared.core.js_complex.compiler.Js_complexLexer;
import pt.isep.nsheets.shared.core.js_complex.compiler.Js_complexParser;
import pt.isep.nsheets.shared.core.js_complex.compiler.Js_complexParser.*;

public class EvalVisitor extends Js_complexBaseVisitor<Value> {

    // used to compare floating point numbers
    private static final double SMALL_VALUE = 0.00000000001;

    private Map<String, Value> memory = new HashMap<>();
    private Map<String, Value> cells;
    private Map<String, String> functions;
    private Map<String, Value> block_memory;
    private String output = "";
    private boolean func_created = true;

    //receives current sheet cells
    public EvalVisitor(Map<String, Value> cells, Map<String, String> functions) {
        this.cells = cells;

        if (functions == null) {
            functions = new HashMap<>();
        }

        this.functions = functions;
    }

    @Override
    public Value visitAssignment(AssignmentContext ctx) {
        String id = ctx.ID().getText();
        Value value;

        System.out.println("Assigment: ");

        if (this.visit(ctx.expr()).isDouble()) {
            value = new Value(this.visit(ctx.expr()).asDouble());
        } else {
            value = new Value(this.visit(ctx.expr()).asString());
        }

        if (id.startsWith("$")) {
            return cells.put(id.substring(1), value);
        }

        if (!id.startsWith("$") && !ctx.getChild(0).getText().equals("var") && !memory.containsKey(id)) {
            throw new RuntimeException("Invalid assigment");
        }

        if (ctx.getParent().getParent().getParent().getRuleIndex() == Js_complexParser.RULE_functionblock) {
            if (!id.startsWith("$")) {
                if (memory.get(id) != null) {
                    return memory.put(id, value);
                }
                return block_memory.put(id, value);
            }
        }
        return memory.put(id, value);
    }

    @Override
    public Value visitIdAtom(IdAtomContext ctx) {
        String id = ctx.getText();
        Value value;
        if (id.startsWith("$")) {
            value = cells.get(id.substring(1));
        } else {
            if (memory.get(id) != null) {
                value = memory.get(id);
            } else if (block_memory.get(id) != null) {
                value = block_memory.get(id);
            } else {
                value = null;
            }

        }
        if (value == null) {
            throw new RuntimeException("no such variable: " + id);
        }
        return value;
    }

    // atom overrides
    @Override
    public Value visitStringAtom(StringAtomContext ctx) {
        String str = ctx.getText();
        // strip quotes
        str = str.substring(1, str.length() - 1).replace("\"\"", "\"");
        return new Value(str);
    }

    @Override
    public Value visitNumberAtom(NumberAtomContext ctx) {
        return new Value(Double.valueOf(ctx.getText()));
    }

    @Override
    public Value visitBooleanAtom(BooleanAtomContext ctx) {
        return new Value(Boolean.valueOf(ctx.getText()));
    }

    @Override
    public Value visitNilAtom(NilAtomContext ctx) {
        return new Value(null);
    }

    // expr overrides
    @Override
    public Value visitParExpr(ParExprContext ctx) {
        return this.visit(ctx.expr());
    }

    @Override
    public Value visitPowExpr(PowExprContext ctx) {
        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));
        return new Value(Math.pow(left.asDouble(), right.asDouble()));
    }

    @Override
    public Value visitUnaryMinusExpr(UnaryMinusExprContext ctx) {
        Value value = this.visit(ctx.expr());
        return new Value(-value.asDouble());
    }

    @Override
    public Value visitNotExpr(NotExprContext ctx) {
        Value value = this.visit(ctx.expr());
        return new Value(!value.asBoolean());
    }

    @Override
    public Value visitMultiplicationExpr(@NotNull MultiplicationExprContext ctx) {

        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));

        switch (ctx.op.getType()) {
            case JsParser.MULT:
                return new Value(left.asDouble() * right.asDouble());
            case JsParser.DIV:
                return new Value(left.asDouble() / right.asDouble());
            case JsParser.MOD:
                return new Value(left.asDouble() % right.asDouble());
            default:
                throw new RuntimeException("unknown operator: " + JsParser.tokenNames[ctx.op.getType()]);
        }
    }

    @Override
    public Value visitAdditiveExpr(@NotNull AdditiveExprContext ctx) {

        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));

        switch (ctx.op.getType()) {
            case JsParser.PLUS:
                return left.isDouble() && right.isDouble()
                        ? new Value(left.asDouble() + right.asDouble())
                        : new Value(left.asString() + right.asString());
            case JsParser.MINUS:
                return new Value(left.asDouble() - right.asDouble());
            default:
                throw new RuntimeException("unknown operator: " + JsParser.tokenNames[ctx.op.getType()]);
        }
    }

    @Override
    public Value visitRelationalExpr(@NotNull RelationalExprContext ctx) {

        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));

        switch (ctx.op.getType()) {
            case JsParser.LT:
                return new Value(left.asDouble() < right.asDouble());
            case JsParser.LTEQ:
                return new Value(left.asDouble() <= right.asDouble());
            case JsParser.GT:
                return new Value(left.asDouble() > right.asDouble());
            case JsParser.GTEQ:
                return new Value(left.asDouble() >= right.asDouble());
            default:
                throw new RuntimeException("unknown operator: " + JsParser.tokenNames[ctx.op.getType()]);
        }
    }

    @Override
    public Value visitEqualityExpr(@NotNull EqualityExprContext ctx) {

        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));

        switch (ctx.op.getType()) {
            case JsParser.EQ:
                return left.isDouble() && right.isDouble()
                        ? new Value(Math.abs(left.asDouble() - right.asDouble()) < SMALL_VALUE)
                        : new Value(left.equals(right));
            case JsParser.NEQ:
                return left.isDouble() && right.isDouble()
                        ? new Value(Math.abs(left.asDouble() - right.asDouble()) >= SMALL_VALUE)
                        : new Value(!left.equals(right));
            default:
                throw new RuntimeException("unknown operator: " + JsParser.tokenNames[ctx.op.getType()]);
        }
    }

    @Override
    public Value visitAndExpr(AndExprContext ctx) {
        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));
        return new Value(left.asBoolean() && right.asBoolean());
    }

    @Override
    public Value visitOrExpr(OrExprContext ctx) {
        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));
        return new Value(left.asBoolean() || right.asBoolean());
    }

    // log override
    @Override
    public Value visitLog(LogContext ctx) {
        Value value = this.visit(ctx.expr());
        this.output += value.toString() + "\n";
        return value;
    }

    // if override
    @Override
    public Value visitIf_stat(If_statContext ctx) {

        List<Condition_blockContext> conditions = ctx.condition_block();

        boolean evaluatedBlock = false;

        for (Condition_blockContext condition : conditions) {

            Value evaluated = this.visit(condition.expr());

            if (evaluated.asBoolean()) {
                evaluatedBlock = true;
                // evaluate this block whose expr==true
                this.visit(condition.stat_block());
                break;
            }
        }

        if (!evaluatedBlock && ctx.stat_block() != null) {
            // evaluate the else-stat_block (if present == not null)
            this.visit(ctx.stat_block());
        }

        return Value.VOID;
    }

    // while override
    @Override
    public Value visitWhile_stat(While_statContext ctx) {

        Value value = this.visit(ctx.expr());

        while (value.asBoolean()) {

            // evaluate the code block
            this.visit(ctx.stat_block());

            // evaluate the expression
            value = this.visit(ctx.expr());
        }

        return Value.VOID;
    }

    @Override
    public Value visitFunc_call(@NotNull Func_callContext ctx) {

        String func_id = ctx.ID().getText();
        String function_content = functions.get(func_id);
        if (function_content != null) {
//Verificar se o retorno for void, não pode fazer atribuição
//TO DO how to call a function  

            if (ctx.getParent().getParent().getParent() instanceof FunctionContext) {
                FunctionContext parent = (FunctionContext) ctx.getParent().getParent().getParent();
                if (parent.ID().getText().equals(func_id)) {
//                consoleError("You cannot invoke yourself");
//                return Value.VOID;
                    throw new RuntimeException("Invoke itself");
                }
            } else if (ctx.getParent().getParent().getParent().getParent().getParent() instanceof FunctionContext) {
                FunctionContext parent = (FunctionContext) ctx.getParent().getParent().getParent().getParent().getParent();
                if (parent.ID().getText().equals(func_id)) {
//                consoleError("You cannot invoke yourself");
//                return Value.VOID;
                    throw new RuntimeException("Invoke itself");
                }
            }

            String functionToVisit = "function " + func_id + "(){ " + function_content + " }";
            Js_complexLexer lexer = new Js_complexLexer(new ANTLRInputStream(functionToVisit));
            Js_complexParser parser = new Js_complexParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.block();
            Value value = this.visit(tree);

            if (ctx.getParent().getParent() instanceof AssignmentContext) {
                if (value == Value.VOID) {
                    throw new RuntimeException("The function return is VOID");
                }
            }
            return value;
        } else {
            throw new RuntimeException("The function with the id: " + ctx.ID().getText() + " does not already exists!");
        }
    }

    @Override
    public Value visitFunctionblock(@NotNull FunctionblockContext ctx) {
        // A função verifica o retorno, e se ele for void desconsidera, senão retorna esse valor
//        this.visit(ctx.stat());

//        FunctionContext parent = (FunctionContext) ctx.getParent();
        Value returnValue;
//
//        if (functions.containsKey(parent.ID().getText())) {
            ctx.stat().forEach((stat) -> {
                this.visit(stat);
            });

            if (ctx.returnstatement() == null) {
                return Value.VOID;
            }

            returnValue = this.visit(ctx.returnstatement());
//        } else {
//            returnValue = Value.VOID;
//        }

        return returnValue;
    }

    @Override
    public Value visitReturnstatement(ReturnstatementContext ctx) {
        if (ctx.expr() != null) {
            return this.visit(ctx.expr());
        } else if (ctx.assignment() != null) {
            return this.visit(ctx.assignment());
        } else {
            return Value.VOID;
        }
    }

    @Override
    public Value visitFunction(@NotNull FunctionContext ctx) {
        String id = ctx.ID().getText();
        Value return_value;
        if (id.startsWith("$")) {
            throw new RuntimeException("The function id canNOT start with $ ");
        }
        block_memory = new HashMap<>();
        if (functions.containsKey(id)) {

            return_value = this.visit(ctx.functionblock());

            this.block_memory.clear();

        } else {
            functions.put(id, getFullText(ctx.functionblock()));
            
            if (ctx.CBRACE().getText().length() != 1) {
                String error = "You should close your function!";
                consoleError(error);
                return Value.VOID;
            }
            
                return_value = this.visit(ctx.functionblock());
            

            this.block_memory.clear();

        }
        return return_value;

    }

    public String getOutput() {
        return output;
    }

    private void consoleError(String msg) {
        output += "\n!ERROR!: " + msg + "\n";
    }

    public static String getFullText(ParserRuleContext ctx) {

        if (ctx.start == null || ctx.stop == null || ctx.start.getStartIndex() < 0 || ctx.stop.getStopIndex() < 0) {
            return ctx.getText(); // Fallback
        }
        return ctx.start.getInputStream().getText(Interval.of(ctx.start.getStartIndex(), ctx.stop.getStopIndex()));
    }

}
