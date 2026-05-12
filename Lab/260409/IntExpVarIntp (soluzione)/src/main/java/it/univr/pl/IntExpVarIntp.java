package it.univr.pl;

import java.util.HashMap;
import java.util.Map;

public class IntExpVarIntp extends IntExpVarBaseVisitor<Integer> {

    private final Map<String, Integer> mem = new HashMap<>();

    @Override
    public Integer visitMain(IntExpVarParser.MainContext ctx) {
        return visit(ctx.prog());
    }

    @Override
    public Integer visitProg(IntExpVarParser.ProgContext ctx) {
        visit(ctx.init());
        return visit(ctx.exp());
    }

    @Override
    public Integer visitIdinit(IntExpVarParser.IdinitContext ctx) {
        String id = ctx.ID().getText();
        Integer val = visit(ctx.exp());

        mem.put(id, val);

        return visit(ctx.init());
    }

    @Override
    public Integer visitNilinit(IntExpVarParser.NilinitContext ctx) {
        return null;
    }

    @Override
    public Integer visitVal(IntExpVarParser.ValContext ctx) {
        return Integer.parseInt(ctx.VAL().getText());
    }

    @Override
    public Integer visitId(IntExpVarParser.IdContext ctx) {
        return mem.getOrDefault(ctx.ID().getText(), 0);
    }

    @Override
    public Integer visitAdd(IntExpVarParser.AddContext ctx) {
        Integer left = visit(ctx.exp(0));
        Integer right = visit(ctx.exp(1));
        return left + right;
    }

    @Override
    public Integer visitMul(IntExpVarParser.MulContext ctx) {
        Integer left = visit(ctx.exp(0));
        Integer right = visit(ctx.exp(1));
        return left * right;
    }

    @Override
    public Integer visitSub(IntExpVarParser.SubContext ctx) {
        Integer left = visit(ctx.exp(0));
        Integer right = visit(ctx.exp(1));
        return left - right;
    }

    @Override
    public Integer visitDiv(IntExpVarParser.DivContext ctx) {
        Integer left = visit(ctx.exp(0));
        Integer right = visit(ctx.exp(1));
        return left / right;
    }

    @Override
    public Integer visitMod(IntExpVarParser.ModContext ctx) {
        Integer left = visit(ctx.exp(0));
        Integer right = visit(ctx.exp(1));
        return left % right;
    }
}
