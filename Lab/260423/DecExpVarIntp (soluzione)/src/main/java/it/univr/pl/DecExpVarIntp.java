package it.univr.pl;

import java.util.HashMap;
import java.util.Map;

public class DecExpVarIntp extends DecExpVarBaseVisitor<Double> {

  private final Map<String, Double> mem = new HashMap<>();

  @Override
  public Double visitMain(DecExpVarParser.MainContext ctx) {
      return visit(ctx.prog());
  }

  @Override
  public Double visitProg(DecExpVarParser.ProgContext ctx) {
      visit(ctx.init());
      return visit(ctx.exp());
  }

  @Override
  public Double visitInit(DecExpVarParser.InitContext ctx) {
      for (int i = 0; i < ctx.exp().size(); i++) {
          String id = ctx.ID(i).getText();
          Double val = visit(ctx.exp(i));

          mem.put(id, val);
      }
      return null;
  }

  @Override
  public Double visitVal(DecExpVarParser.ValContext ctx) {
      return Double.parseDouble(ctx.VAL().getText());
  }

  @Override
  public Double visitId(DecExpVarParser.IdContext ctx) {
      return mem.getOrDefault(ctx.ID().getText(), 0.0);
  }

  @Override
  public Double visitAddSub(DecExpVarParser.AddSubContext ctx) {
      return switch (ctx.op.getType()) {
          case DecExpVarParser.ADD  -> visit(ctx.exp(0)) + visit(ctx.exp(1));
          case DecExpVarParser.SUB -> visit(ctx.exp(0)) - visit(ctx.exp(1));
          default -> null; // unreachable code
      };
  }

  @Override
  public Double visitMulDivMod(DecExpVarParser.MulDivModContext ctx) {
      return switch (ctx.op.getType()) {
          case DecExpVarParser.MUL -> visit(ctx.exp(0)) * visit(ctx.exp(1));
          case DecExpVarParser.DIV   -> visit(ctx.exp(0)) / visit(ctx.exp(1));
          case DecExpVarParser.MOD   -> visit(ctx.exp(0)) % visit(ctx.exp(1));
          default -> null; // unreachable code
      };
  }

  @Override
  public Double visitPow(DecExpVarParser.PowContext ctx) {
      return Math.pow(visit(ctx.exp(0)), visit(ctx.exp(1)));
  }

  @Override
  public Double visitParExp(DecExpVarParser.ParExpContext ctx) {
      return visit(ctx.exp());
  }
}
