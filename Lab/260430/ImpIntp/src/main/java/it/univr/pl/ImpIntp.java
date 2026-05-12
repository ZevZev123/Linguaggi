package it.univr.pl;

import it.univr.pl.exception.TypeMismatchException;
import it.univr.pl.exception.UnknownVariableException;
import it.univr.pl.value.*;

public class ImpIntp extends ImpBaseVisitor<Value> {

    private final Mem mem;

    public ImpIntp() {
        this.mem = new Mem();
    }

    public ImpIntp(Mem mem) {
        if (mem != null) this.mem = mem;
        else this.mem = new Mem();
    }

    public Mem getMem() {
        return mem;
    }

    private BoolValue visitBoolExp(ImpParser.ExpContext ctx) {
        try {
            return (BoolValue) visit(ctx);
        } catch (ClassCastException cce) {
            String err = "Type mismatch!\n" +
                    "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n" +
                    "Boolean expression expected";
            throw new TypeMismatchException(err);
        }
    }

    private IntValue visitIntExp(ImpParser.ExpContext ctx) {
        try {
            return (IntValue) visit(ctx);
        } catch (ClassCastException cce) {
            String err = "Type mismatch!\n" +
                    "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n" +
                    "Integer expression expected";
            throw new TypeMismatchException(err);
        }
    }

    @Override
    public ComValue visitMain(ImpParser.MainContext ctx) {
        return (ComValue) visit(ctx.com());
    }

    @Override
    public ComValue visitIf(ImpParser.IfContext ctx) {
        BoolValue condition = visitBoolExp(ctx.exp());
        return condition.toJavaValue()
                ? (ComValue) visit(ctx.com())
                : ComValue.INSTANCE;
    }

    @Override
    public ComValue visitAssign(ImpParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        ExpValue<?> val = (ExpValue<?>) visit(ctx.exp());
        mem.update(id, val);

        return ComValue.INSTANCE;
    }

    @Override
    public ComValue visitSeq(ImpParser.SeqContext ctx) {
        visit(ctx.com(0));
        return (ComValue) visit(ctx.com(1));
    }

    @Override
    public BoolValue visitBoolean(ImpParser.BooleanContext ctx) {
        return new BoolValue(Boolean.parseBoolean(ctx.BOOL().getText()));
    }

    @Override
    public IntValue visitInteger(ImpParser.IntegerContext ctx) {
        return new IntValue(Integer.parseInt(ctx.INT().getText()));
    }

    @Override
    public ExpValue<?> visitId(ImpParser.IdContext ctx) {
        String id = ctx.ID().getText();

        if (!mem.contains(id)) {
            String err = "Variable " + id + " used but not initialized!\n" +
                    "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine();
            throw new UnknownVariableException(err);
        }

        return mem.get(id);
    }

    @Override
    public ComValue visitWhile(ImpParser.WhileContext ctx) {
        if (!visitBoolExp(ctx.exp()).toJavaValue())
            return ComValue.INSTANCE;

        visit(ctx.com());

        return visitWhile(ctx);
    }

    @Override
    public BoolValue visitNot(ImpParser.NotContext ctx) {
        return new BoolValue(!visitBoolExp(ctx.exp()).toJavaValue());
    }

    @Override
    public ExpValue<?> visitParExp(ImpParser.ParExpContext ctx) {
        return (ExpValue<?>) visit(ctx.exp());
    }

    @Override
    public IntValue visitPow(ImpParser.PowContext ctx) {
        IntValue base = visitIntExp(ctx.exp(0));
        IntValue exponent = visitIntExp(ctx.exp(1));

        double result = Math.pow(base.toJavaValue(), exponent.toJavaValue());
        return new IntValue((int) result);
    }

    @Override
    public ExpValue<?> visitMulDivMod(ImpParser.MulDivModContext ctx) {
        IntValue left = visitIntExp(ctx.exp(0));
        IntValue right = visitIntExp(ctx.exp(1));

        return switch (ctx.op.getType()) {
            case ImpParser.DIV -> new IntValue(left.toJavaValue() / right.toJavaValue());
            case ImpParser.MUL -> new IntValue(left.toJavaValue() * right.toJavaValue());
            case ImpParser.MOD -> new IntValue(left.toJavaValue() % right.toJavaValue());
            default -> null; // unreachable code
        };
    }

    @Override
    public ExpValue<?> visitAddSub(ImpParser.AddSubContext ctx) {
        IntValue left = visitIntExp(ctx.exp(0));
        IntValue right = visitIntExp(ctx.exp(1));

        return switch (ctx.op.getType()) {
            case ImpParser.ADD -> new IntValue(left.toJavaValue() + right.toJavaValue());
            case ImpParser.SUB -> new IntValue(left.toJavaValue() - right.toJavaValue());
            default -> null; // unreachable code
        };
    }

    @Override
    public BoolValue visitEqExp(ImpParser.EqExpContext ctx) {
        ExpValue<?> left = (ExpValue<?>) visit(ctx.exp(0));
        ExpValue<?> right = (ExpValue<?>) visit(ctx.exp(1));

        return switch (ctx.op.getType()) {
            case ImpParser.EQQ -> new BoolValue(left.equals(right));
            case ImpParser.NEQ -> new BoolValue(!left.equals(right));
            default -> null; // never reached
        };
    }

    @Override
    public BoolValue visitCmpExp(ImpParser.CmpExpContext ctx) {
        IntValue left = visitIntExp(ctx.exp(0));
        IntValue right = visitIntExp(ctx.exp(1));

        return switch (ctx.op.getType()) {
            case ImpParser.GEQ -> new BoolValue(left.toJavaValue() >= right.toJavaValue());
            case ImpParser.LEQ -> new BoolValue(left.toJavaValue() <= right.toJavaValue());
            case ImpParser.LT  -> new BoolValue(left.toJavaValue() < right.toJavaValue());
            case ImpParser.GT  -> new BoolValue(left.toJavaValue() > right.toJavaValue());
            default -> null; // unreachable code
        };
    }

    @Override
    public BoolValue visitAndOr(ImpParser.AndOrContext ctx) {
        BoolValue left = visitBoolExp(ctx.exp(0));
        BoolValue right = visitBoolExp(ctx.exp(1));

        return switch (ctx.op.getType()) {
            case ImpParser.AND -> new BoolValue(left.toJavaValue() && right.toJavaValue());
            case ImpParser.OR -> new BoolValue(left.toJavaValue() || right.toJavaValue());
            default -> null; // unreachable code
        };
    }
}
