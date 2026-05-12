package it.univr.pl;

import it.univr.pl.type.SimpleType;
import org.apache.commons.text.StringEscapeUtils;
import it.univr.pl.value.*;

public class TypedImpIntp extends TypedImpBaseVisitor<Value> {

    private final Mem mem;

    public TypedImpIntp() {
        this.mem = new Mem();
    }

    public Mem getMem() {
        return mem;
    }

    private ComValue visitCom(TypedImpParser.ComContext ctx) {
        return (ComValue) visit(ctx);
    }

    private ExpValue<?> visitExp(TypedImpParser.ExpContext ctx) {
        return (ExpValue<?>) visit(ctx);
    }

    private NumValue<?> visitNumExp(TypedImpParser.ExpContext ctx) {
        return (NumValue<?>) visitExp(ctx);
    }

    private BoolValue visitBoolExp(TypedImpParser.ExpContext ctx) {
        return (BoolValue) visitExp(ctx);
    }

    private StringValue visitStringExp(TypedImpParser.ExpContext ctx) {
        return (StringValue) visitExp(ctx);
    }

    private double unwrapToDouble(NumValue<?> numValue) {
        return numValue.toJavaValue().doubleValue();
    }

    @Override
    public ComValue visitMain(TypedImpParser.MainContext ctx) {
        visit(ctx.decl());
        return visitCom(ctx.com());
    }

    @Override
    public ComValue visitDecl(TypedImpParser.DeclContext ctx) {

        for (int i = 0; i < ctx.ID().size(); i ++) {
            SimpleType type = SimpleType.fromString(ctx.TYPE(i).getText());
            String id = ctx.ID(i).getText();
            mem.add(id, type);
        }

        return ComValue.INSTANCE;
    }

    @Override
    public ComValue visitIf(TypedImpParser.IfContext ctx) {
        return visitBoolExp(ctx.exp()).toJavaValue()
                ? visitCom(ctx.com())
                : ComValue.INSTANCE;
    }

    @Override
    public ComValue visitIfElse(TypedImpParser.IfElseContext ctx) {
        return visitBoolExp(ctx.exp()).toJavaValue()
                ? visitCom(ctx.com(0))
                : visitCom(ctx.com(1));
    }

    @Override
    public ComValue visitAssign(TypedImpParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        ExpValue<?> v = visitExp(ctx.exp());

        mem.updateValue(id, v);

        return ComValue.INSTANCE;
    }

    @Override
    public ComValue visitSeq(TypedImpParser.SeqContext ctx) {
        visitCom(ctx.com(0));
        return visitCom(ctx.com(1));
    }

    @Override
    public ComValue visitWhile(TypedImpParser.WhileContext ctx) {
        if (!visitBoolExp(ctx.exp()).toJavaValue())
            return ComValue.INSTANCE;

        visitCom(ctx.com());

        return visitWhile(ctx);
    }

    @Override
    public ComValue visitOut(TypedImpParser.OutContext ctx) {
        System.out.println(visitStringExp(ctx.exp()).toJavaValue());
        return ComValue.INSTANCE;
    }

    @Override
    public ComValue visitNop(TypedImpParser.NopContext ctx) {
        return ComValue.INSTANCE;
    }

    @Override
    public NumValue<?> visitNumeric(TypedImpParser.NumericContext ctx) {
        return (NumValue<?>) visit(ctx.num());
    }

    @Override
    public IntValue visitIntNum(TypedImpParser.IntNumContext ctx) {
        return new IntValue(Integer.parseInt(ctx.INT().getText()));
    }

    @Override
    public DecValue visitDecNum(TypedImpParser.DecNumContext ctx) {
        return new DecValue(Double.parseDouble(ctx.DEC().getText()));
    }

    @Override
    public BoolValue visitBoolean(TypedImpParser.BooleanContext ctx) {
        return new BoolValue(Boolean.parseBoolean(ctx.BOOL().getText()));
    }

    @Override
    public StringValue visitString(TypedImpParser.StringContext ctx) {
        String str = ctx.STRING().getText().substring(1, ctx.STRING().getText().length() - 1);
        return new StringValue(StringEscapeUtils.unescapeJava(str));
    }

    @Override
    public ExpValue<?> visitParExp(TypedImpParser.ParExpContext ctx) {
        return visitExp(ctx.exp());
    }

    @Override
    public Value visitTostr(TypedImpParser.TostrContext ctx) {
        return new StringValue(visitExp(ctx.exp()).toJavaValue().toString());
    }

    @Override
    public ExpValue<?> visitPow(TypedImpParser.PowContext ctx) {
        NumValue<?> base = visitNumExp(ctx.exp(0));
        NumValue<?> exponent = visitNumExp(ctx.exp(1));

        double result = Math.pow(unwrapToDouble(base), unwrapToDouble(exponent));
        if (SimpleType.fromValue(base) == SimpleType.INT) return new IntValue((int) result);
        else return new DecValue(result);
    }

    @Override
    public BoolValue visitNot(TypedImpParser.NotContext ctx) {
        return new BoolValue(!visitBoolExp(ctx.exp()).toJavaValue());
    }

    @Override
    public ExpValue<?> visitMulDivMod(TypedImpParser.MulDivModContext ctx) {
        NumValue<?> left = visitNumExp(ctx.exp(0));
        NumValue<?> right = visitNumExp(ctx.exp(1));

        Double result;
        switch (ctx.op.getType()) {
            case TypedImpParser.DIV -> result = unwrapToDouble(left) / unwrapToDouble(right);
            case TypedImpParser.MUL -> result = unwrapToDouble(left) * unwrapToDouble(right);
            case TypedImpParser.MOD -> result = unwrapToDouble(left) % unwrapToDouble(right);
            default -> result = null; // unreachable code
        }

        assert result != null; // always true
        if (SimpleType.fromValue(left) == SimpleType.INT) return new IntValue((int) result.doubleValue());
        else return new DecValue(result);
    }

    @Override
    public ExpValue<?> visitAddSub(TypedImpParser.AddSubContext ctx) {
        NumValue<?> left = visitNumExp(ctx.exp(0));
        NumValue<?> right = visitNumExp(ctx.exp(1));

        Double result;
        switch (ctx.op.getType()) {
            case TypedImpParser.ADD -> result = unwrapToDouble(left) + unwrapToDouble(right);
            case TypedImpParser.SUB -> result = unwrapToDouble(left) - unwrapToDouble(right);
            default -> result = null; // unreachable code
        }

        assert result != null; // always true
        if (SimpleType.fromValue(left) == SimpleType.INT) return new IntValue((int) result.doubleValue());
        else return new DecValue(result);
    }

    @Override
    public BoolValue visitEqExp(TypedImpParser.EqExpContext ctx) {
        ExpValue<?> left = visitExp(ctx.exp(0));
        ExpValue<?> right = visitExp(ctx.exp(1));

        return switch (ctx.op.getType()) {
            case TypedImpParser.EQQ -> new BoolValue(left.equals(right));
            case TypedImpParser.NEQ -> new BoolValue(!left.equals(right));
            default -> null; // unreachable code
        };
    }

    @Override
    public ExpValue<?> visitId(TypedImpParser.IdContext ctx) {
        String id = ctx.ID().getText();

        return mem.getValue(id);
    }

    @Override
    public BoolValue visitCmpExp(TypedImpParser.CmpExpContext ctx) {
        NumValue<?> left = visitNumExp(ctx.exp(0));
        NumValue<?> right = visitNumExp(ctx.exp(1));

        return switch (ctx.op.getType()) {
            case TypedImpParser.GEQ -> new BoolValue(unwrapToDouble(left) >= unwrapToDouble(right));
            case TypedImpParser.LEQ -> new BoolValue(unwrapToDouble(left) <= unwrapToDouble(right));
            case TypedImpParser.LT -> new BoolValue(unwrapToDouble(left) < unwrapToDouble(right));
            case TypedImpParser.GT -> new BoolValue(unwrapToDouble(left) > unwrapToDouble(right));
            default -> null; // unreachable code
        };
    }

    @Override
    public BoolValue visitAndOr(TypedImpParser.AndOrContext ctx) {
        BoolValue left = visitBoolExp(ctx.exp(0));
        BoolValue right = visitBoolExp(ctx.exp(1));

        return switch (ctx.op.getType()) {
            case TypedImpParser.AND -> new BoolValue(left.toJavaValue() && right.toJavaValue());
            case TypedImpParser.OR -> new BoolValue(left.toJavaValue() || right.toJavaValue());
            default -> null;
        };
    }

    @Override
    public StringValue visitConcat(TypedImpParser.ConcatContext ctx) {
        StringValue left = visitStringExp(ctx.exp(0));
        StringValue right = visitStringExp(ctx.exp(1));

        return new StringValue(left.toJavaValue() + right.toJavaValue());
    }

}
