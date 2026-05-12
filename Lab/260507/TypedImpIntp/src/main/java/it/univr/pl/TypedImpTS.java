package it.univr.pl;

import it.univr.pl.exception.TypeMismatchException;
import it.univr.pl.exception.VarDeclarationException;
import it.univr.pl.type.*;
import java.util.HashMap;
import java.util.Map;

public class TypedImpTS extends TypedImpBaseVisitor<Type> {

    private final Map<String, ExpType> typeMap = new HashMap<>();

    private ComType visitCom(TypedImpParser.ComContext ctx) {
        return (ComType) visit(ctx);
    }

    private SimpleType visitBoolExp(TypedImpParser.ExpContext ctx) {
        ExpType expType = (ExpType) visit(ctx);
        if (!expType.isCompatible(SimpleType.BOOL)) { // not boolean expression
            String err = "Type mismatch: boolean expression expected.\n" +
                         "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n";
            throw new TypeMismatchException(err);
        }

        return SimpleType.BOOL;
    }

    private SimpleType visitStringExp(TypedImpParser.ExpContext ctx) {
        ExpType expType = (ExpType) visit(ctx);
        if (!expType.isCompatible(SimpleType.STRING)) { // not string expression
            String err = "Type mismatch: string expression expected.\n" +
                         "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n";
            throw new TypeMismatchException(err);
        }

        return SimpleType.STRING;
    }

    private SimpleType visitNumExp(TypedImpParser.ExpContext ctx) {
        ExpType expType = (ExpType) visit(ctx);
        if (!expType.isCompatible(SimpleType.INT) && !expType.isCompatible(SimpleType.DEC)) { // not numeric expression
            String err = "Type mismatch: numeric expression expected.\n" +
                         "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n";
            throw new TypeMismatchException(err);
        }

        return (SimpleType) expType;
    }

    @Override
    public ComType visitMain(TypedImpParser.MainContext ctx) {
        visit(ctx.decl());
        return (ComType) visit(ctx.com());
    }

    @Override
    public ComType visitDecl(TypedImpParser.DeclContext ctx) {

        for (int i = 0; i < ctx.ID().size(); i ++) {
            SimpleType type = SimpleType.fromString(ctx.TYPE(i).getText());
            String id = ctx.ID(i).getText();
            if (typeMap.containsKey(id)) { // already declared variable
                String err = "Variable " + id + " already declared.\n" +
                             "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n";
                throw new VarDeclarationException(err);
            }
            typeMap.put(id, type);
        }

        return ComType.INSTANCE;
    }

    @Override
    public Type visitWhile(TypedImpParser.WhileContext ctx) {
        visitBoolExp(ctx.exp());

        return visit(ctx.com());
    }

    @Override
    public ComType visitIf(TypedImpParser.IfContext ctx) {
        visitBoolExp(ctx.exp());

        return visitCom(ctx.com());
    }

    @Override
    public ComType visitIfElse(TypedImpParser.IfElseContext ctx) {
        visitBoolExp(ctx.exp());

        visitCom(ctx.com(0));

        return visitCom(ctx.com(1));
    }

    @Override
    public ComType visitAssign(TypedImpParser.AssignContext ctx) {
        String id = ctx.ID().getText();

        if (!typeMap.containsKey(id)) { // assignment to not declared variable
            String err = "Variable " + id + " assigned but never declared.\n" +
                         "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n";
            throw new VarDeclarationException(err);
        }

        ExpType varType = typeMap.get(id);
        ExpType expType = (ExpType) visit(ctx.exp());
        if (!varType.isCompatible(expType)) { // type mismatch
            String err = "Variable " + id + " cannot be assigned with " + expType.getName() + ".\n"+
                         "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n";
            throw new TypeMismatchException(err);
        }

        return ComType.INSTANCE;
    }

    @Override
    public ComType visitSeq(TypedImpParser.SeqContext ctx) {
        visitCom(ctx.com(0));
        return visitCom(ctx.com(1));
    }

    @Override
    public ExpType visitId(TypedImpParser.IdContext ctx) {
        String id = ctx.ID().getText();
        if (!typeMap.containsKey(id)) { // not declared variable
            String err = "Variable " + id + " not declared.\n" +
                         "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n";
            throw new VarDeclarationException(err);
        }

        return typeMap.get(id);
    }

    @Override
    public ComType visitOut(TypedImpParser.OutContext ctx) {
        visitStringExp(ctx.exp());

        return ComType.INSTANCE;
    }

    @Override
    public ComType visitNop(TypedImpParser.NopContext ctx) {
        return ComType.INSTANCE;
    }

    @Override
    public SimpleType visitTostr(TypedImpParser.TostrContext ctx) {
        visit(ctx.exp());

        return SimpleType.STRING;
    }

    @Override
    public SimpleType visitMulDivMod(TypedImpParser.MulDivModContext ctx) {
        SimpleType left = visitNumExp(ctx.exp(0));
        SimpleType right = visitNumExp(ctx.exp(1));

        if (left != right) {
            String err = "Type mismatch: the operation cannot be applied to the given operands.\n" +
                         "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n";
            throw new TypeMismatchException(err);
        }

        return left;
    }

    @Override
    public SimpleType visitString(TypedImpParser.StringContext ctx) {
        return SimpleType.STRING;
    }

    @Override
    public SimpleType visitNumeric(TypedImpParser.NumericContext ctx) {
        return (SimpleType) visit(ctx.num());
    }

    @Override
    public SimpleType visitIntNum(TypedImpParser.IntNumContext ctx) {
        return SimpleType.INT;
    }

    @Override
    public SimpleType visitDecNum(TypedImpParser.DecNumContext ctx) {
        return SimpleType.DEC;
    }

    @Override
    public Type visitAddSub(TypedImpParser.AddSubContext ctx) {
        SimpleType left = visitNumExp(ctx.exp(0));
        SimpleType right = visitNumExp(ctx.exp(1));

        if (left != right) {
            String err = "Type mismatch: the operation cannot be applied to the given operands.\n" +
                         "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n";
            throw new TypeMismatchException(err);
        }

        return left;
    }

    @Override
    public SimpleType visitConcat(TypedImpParser.ConcatContext ctx) {
        visitStringExp(ctx.exp(0));
        visitStringExp(ctx.exp(1));

        return SimpleType.STRING;
    }

    @Override
    public SimpleType visitAndOr(TypedImpParser.AndOrContext ctx) {
        visitBoolExp(ctx.exp(0));
        visitBoolExp(ctx.exp(1));

        return SimpleType.BOOL;
    }

    @Override
    public SimpleType visitNot(TypedImpParser.NotContext ctx) {
        visitBoolExp(ctx.exp());

        return SimpleType.BOOL;
    }

    @Override
    public SimpleType visitEqExp(TypedImpParser.EqExpContext ctx) {
        ExpType left = (ExpType) visit(ctx.exp(0));
        ExpType right = (ExpType) visit(ctx.exp(1));

        if (left != right) {
            String err = "Type mismatch: the operation cannot be applied to the given operands.\n" +
                         "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n";
            throw new TypeMismatchException(err);
        }

        return SimpleType.BOOL;
    }

    @Override
    public SimpleType visitBoolean(TypedImpParser.BooleanContext ctx) {
        return SimpleType.BOOL;
    }

    @Override
    public SimpleType visitCmpExp(TypedImpParser.CmpExpContext ctx) {
        SimpleType left = visitNumExp(ctx.exp(0));
        SimpleType right = visitNumExp(ctx.exp(1));

        if (left != right) {
            String err = "Type mismatch: the operation cannot be applied to the given operands.\n" +
                         "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n";
            throw new TypeMismatchException(err);
        }

        return SimpleType.BOOL;
    }

    @Override
    public ExpType visitParExp(TypedImpParser.ParExpContext ctx) {
        return (ExpType) visit(ctx.exp());
    }

    @Override
    public SimpleType visitPow(TypedImpParser.PowContext ctx) {
        SimpleType left = visitNumExp(ctx.exp(0));
        SimpleType right = visitNumExp(ctx.exp(1));

        if (left != right) {
            String err = "Type mismatch: the operation cannot be applied to the given operands.\n" +
                         "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n";
            throw new TypeMismatchException(err);
        }

        return left;
    }
}
