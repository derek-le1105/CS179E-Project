import visitor.GJNoArguVisitor;
import java.util.*;

import syntaxtree.*;
import typeCheck.*;
import visitor.*;

public class Pass2 implements GJNoArguVisitor<Scope>{
    Map<String, Holder> phase1 = new HashMap<>();
    public Pass2(Map<String, Holder> phase1Map, Goal root){
        phase1 = phase1Map;
    }

    @Override
    public Scope visit(NodeList n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(NodeListOptional n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(NodeOptional n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(NodeSequence n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(NodeToken n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(Goal n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(MainClass n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(TypeDeclaration n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(ClassDeclaration n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(ClassExtendsDeclaration n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(VarDeclaration n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(MethodDeclaration n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(FormalParameterList n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(FormalParameter n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(FormalParameterRest n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(Type n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(ArrayType n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(BooleanType n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(IntegerType n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(Statement n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(Block n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(AssignmentStatement n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(ArrayAssignmentStatement n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(IfStatement n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(WhileStatement n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(PrintStatement n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(Expression n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(AndExpression n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(CompareExpression n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(PlusExpression n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(MinusExpression n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(TimesExpression n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(ArrayLookup n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(ArrayLength n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(MessageSend n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(ExpressionList n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(ExpressionRest n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(PrimaryExpression n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(IntegerLiteral n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(TrueLiteral n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(FalseLiteral n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(Identifier n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(ThisExpression n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(ArrayAllocationExpression n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(AllocationExpression n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(NotExpression n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scope visit(BracketExpression n) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
