package typeCheck;

import parser.*;
import syntaxtree.*;
import visitor.*;

public class typeCheck implements GJNoArguVisitor<Type> {

    public typeCheck(Goal root){
        
    }

    public void check(){
        
    }

    @Override
    public Type visit(NodeList n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(NodeListOptional n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(NodeOptional n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(NodeSequence n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(NodeToken n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(Goal n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(MainClass n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(TypeDeclaration n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(ClassDeclaration n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(ClassExtendsDeclaration n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(VarDeclaration n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(MethodDeclaration n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(FormalParameterList n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(FormalParameter n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(FormalParameterRest n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(Type n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(ArrayType n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(BooleanType n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(IntegerType n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(Statement n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(Block n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(AssignmentStatement n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(ArrayAssignmentStatement n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(IfStatement ifState) {
        // TODO Auto-generated method stub
        Type type1 = ifState.f2.accept(this);
        if(!(type1 == Boolean.instance()))
            throw new Exception("Non-boolean operand for \"if\".");
        return Boolean.instance();
    }

    @Override
    public Type visit(WhileStatement whileState) {
        // TODO Auto-generated method stub
        Type type1 = whileState.f2.accept(this);
        if(!(type1 == Boolean.instance()))
            throw new Exception("Non-boolean operand for \"while\".");
        return Boolean.instance();
    }

    @Override
    public Type visit(PrintStatement printState) {
        // TODO Auto-generated method stub
        Type type1 = printState.f2.accept(this);
        if(!(type1 == Int.instance()))
            throw new Exception("Non-Integer operand for PrintStatement.");
        return Int.instance();
    }

    @Override
    public Type visit(Expression n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(AndExpression and) {
        // TODO Auto-generated method stub
        Type type1 = and.f0.accept(this);
        if(!(type1 == Boolean.instance()))
            throw new Exception("Non-boolean left operand for \"&&\".");
        Type type2 = and.f0.accept(this);
        if(!(type2 == Boolean.instance()))
            throw new Exception("Non-boolean right operand for \"&&\".");
        return Boolean.instance();
    }

    @Override
    public Type visit(CompareExpression compare) {
        // TODO Auto-generated method stub
        Type type1 = compare.f0.accept(this);
        if(!(type1 == Int.instance())){
            throw new Exception("Non-integer left operand for \"<\".");
        }
        Type type2 = compare.f2.accept(this);
        if(!(type2 == Int.instance())){
            throw new Exception("Non-integer right operand for \"<\".");
        }
        return Boolean.instance();
    }

    @Override
    public Type visit(PlusExpression plus) {
        Type type1 = plus.f0.accept(this);
        if(!(type1 == Int.instance())){
            throw new Exception("Non-integer left operand for \"+\".");
        }
        Type type2 = plus.f2.accept(this);
        if(!(type2 == Int.instance())){
            throw new Exception("Non-integer right operand for \"+\".");
        }
        return Int.instance();
    }

    @Override
    public Type visit(MinusExpression minus) {
        // TODO Auto-generated method stub
        Type type1 = minus.f0.accept(this);
        if(!(type1 == Int.instance())){
            throw new Exception("Non-integer left operand for \"-\".");
        }
        Type type2 = minus.f2.accept(this);
        if(!(type2 == Int.instance())){
            throw new Exception("Non-integer right operand for \"-\".");
        }
        return Int.instance();
    }

    @Override
    public Type visit(TimesExpression times) {
        // TODO Auto-generated method stub
        Type type1 = times.f0.accept(this);
        if(!(type1 == Int.instance())){
            throw new Exception("Non-integer left operand for \"*\".");
        }
        Type type2 = times.f2.accept(this);
        if(!(type2 == Int.instance())){
            throw new Exception("Non-integer right operand for \"*\".");
        }
        return Int.instance();
    }

    @Override
    public Type visit(ArrayLookup n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(ArrayLength n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(MessageSend n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(ExpressionList n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(ExpressionRest n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(PrimaryExpression n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(IntegerLiteral n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(TrueLiteral trueLit) {
        // TODO Auto-generated method stub
        Type type1 = trueLit.f0.accept(this);
        if(!(type1 == Boolean.instance()))
            throw new Exception("Operand for TrueLiteral is not a boolean");
        return Boolean.instance();
    }

    @Override
    public Type visit(FalseLiteral falseLit) {
        // TODO Auto-generated method stub
        Type type1 = falseLit.f0.accept(this);
        if(!(type1 == Boolean.instance()))
            throw new Exception("Operand for FalseLiteral is not a boolean");
        return Boolean.instance();
    }

    @Override
    public Type visit(Identifier n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(ThisExpression n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(ArrayAllocationExpression n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(AllocationExpression n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type visit(NotExpression notExp) {
        // TODO Auto-generated method stub
        Type type1 = notExp.f1.accept(this);
        if(!(type1 == Boolean.instance()))
            throw new Exception("Operand for NotExpression is not a boolean.");
        return Boolean.instance();
    }

    @Override
    public Type visit(BracketExpression n) {
        // TODO Auto-generated method stub
        
    }
}
