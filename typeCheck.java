
//import parser.*;
import java.util.*;

import syntaxtree.*;
import typeCheck.*;
import visitor.*;

public class typeCheck implements GJNoArguVisitor<Scope> {
    // class id, 
    Map<String, Map<String, String>> map = new HashMap<String, Map<String, String>>();
    HashMap<String, String> idHashMap = new HashMap<String, String>(); 

    public typeCheck(Goal root){
        root.f0.accept(this);
        root.f1.accept(this);
    }

    public void check(){
        
    }

    @Override
    public Scope visit(NodeList n) {
        // TODO Auto-generated method stub
        System.out.println("nodelist");
        return Int.instance();
    }

    @Override
    public Scope visit(NodeListOptional nodeListOptional) {
        // TODO Auto-generated method stub
        System.out.println("nodelistoptional");
        for(int i = 0; i < nodeListOptional.nodes.size(); ++i){
            System.out.println("nodeListOptional["+i+"]: "+ nodeListOptional.nodes.elementAt(i));
            nodeListOptional.nodes.elementAt(i).accept(this);
        }
        return Int.instance();
        
    }

    @Override
    public Scope visit(NodeOptional nodeOption) {
        // TODO Auto-generated method stub
        System.out.println("nodeoptional");
        if(nodeOption.present())    
            nodeOption.node.accept(this);
        else
            System.out.println("not present");
        return Int.instance();
    }

    @Override
    public Scope visit(NodeSequence n) {
        // TODO Auto-generated method stub
        System.out.println("nodesequence");
        return Int.instance();
    }

    @Override
    public Scope visit(NodeToken token) {
        // TODO Auto-generated method stub
        System.out.println("nodetoken: " + token.tokenImage);
        //System.out.println("token image: " + token.tokenImage);
        //System.out.println("token kind: " + token.kind);
        return Int.instance();
    }

    @Override
    public Scope visit(Goal goal) {
        // TODO Auto-generated method stub
        System.out.println("goal");
        goal.f1.accept(this);
        return Int.instance();
    }

    @Override
    public Scope visit(MainClass mainClass) {
        // TODO Auto-generated method stub
        System.out.println("mainclass");
        mainClass.f1.accept(this);
        mainClass.f11.accept(this);
        mainClass.f14.accept(this);
        mainClass.f15.accept(this);
        System.out.println("finished mainclass--------------");
        return Int.instance();
    }

    @Override
    public Scope visit(TypeDeclaration typeDec) {
        // TODO Auto-generated method stub
        System.out.println("typedeclaration");
        typeDec.f0.accept(this);
        return Int.instance();
    }

    @Override
    public Scope visit(ClassDeclaration classDec) {
        // TODO Auto-generated method stub
        System.out.println("classdeclaration");
        classDec.f1.accept(this);
        classDec.f3.accept(this);
        System.out.println("classDec f4");
        classDec.f4.accept(this);
        return Int.instance();
    }

    @Override
    public Scope visit(ClassExtendsDeclaration n) {
        // TODO Auto-generated method stub
        System.out.println("classextendsdeclaration");
        return Int.instance();
    }

    @Override
    public Scope visit(VarDeclaration varDec) {//push into hashmap here
        // TODO Auto-generated method stub
        System.out.println("vardeclaration");   
        Scope scope1 = varDec.f0.accept(this);
        Scope scope2 = varDec.f1.accept(this);  
        System.out.println(scope2.name() + "_" + scope1.name());
        idHashMap.put(scope2.name(), scope1.name());
        System.out.println(idHashMap);
        varDec.f1.accept(this);
        return Int.instance();
    }

    @Override
    public Scope visit(MethodDeclaration methodDec) {
        // TODO Auto-generated method stub
        System.out.println("methoddeclaration");
        Scope scope1 = methodDec.f1.accept(this);
        Scope scope2 = methodDec.f2.accept(this);
        idHashMap.put(scope2.name(), scope1.name());
        System.out.println("approaching f4");
        methodDec.f4.accept(this);
        methodDec.f7.accept(this);
        methodDec.f8.accept(this);
        methodDec.f10.accept(this);
        return Int.instance();
    }

    @Override
    public Scope visit(FormalParameterList n) {
        // TODO Auto-generated method stub
        System.out.println("formalparameterlist");
        return Int.instance();
    }

    @Override
    public Scope visit(FormalParameter n) {
        // TODO Auto-generated method stub
        System.out.println("formalparameter");
        return Int.instance();
    }

    @Override
    public Scope visit(FormalParameterRest n) {
        // TODO Auto-generated method stub
        System.out.println("formalparameterrest");
        return Int.instance();
    }

    @Override
    public Scope visit(Type currType) { //=> ArrayType | BooleanType | IntegerType | IDType
        // TODO Auto-generated method stub
        System.out.println("type");
        Scope scope1 = currType.f0.accept(this);
        return scope1;
    }

    @Override
    public Scope visit(ArrayType arrayType) {
        // TODO Auto-generated method stub
        System.out.println("arraytype");
        return Array.instance();
    }

    @Override
    public Scope visit(BooleanType n) {
        // TODO Auto-generated method stub
        System.out.println("booleantype");
        return Bool.instance();
    }

    @Override
    public Scope visit(IntegerType intType) {
        // TODO Auto-generated method stub
        System.out.println("integertype");
        intType.f0.accept(this);
        if(!(intType.f0.tokenImage == "int"))
            throw new Error("Type is not of type Int");
        return Int.instance();
    }

    @Override
    public Scope visit(Statement statement) {
        // TODO Auto-generated method stub
        System.out.println("statement");
        statement.f0.accept(this);
        return Int.instance();
    }

    @Override
    public Scope visit(Block n) {
        // TODO Auto-generated method stub
        System.out.println("block");
        return Int.instance();
    }

    @Override
    public Scope visit(AssignmentStatement assignmentState) {
        // TODO Auto-generated method stub
        System.out.println("assignmentstatement");
        Scope type1 = assignmentState.f0.accept(this);
        String ident = assignmentState.f0.f0.tokenImage;
        if(!idHashMap.containsKey(ident)){
            throw new Error("Not a valid identifier: " + ident);
        }
        Scope type2 = assignmentState.f2.accept(this);
        System.out.println("ident type: " + idHashMap.get(ident));
        System.out.println("type2.name(): " + type2.name());
        if(!(idHashMap.get(ident) == type2.name()))
            throw new Error("Type of ident != type of assignment");
        return type1;
    }

    @Override
    public Scope visit(ArrayAssignmentStatement n) {
        // TODO Auto-generated method stub
        System.out.println("arrayassignmentstatement");
        return Int.instance();
    }

    @Override
    public Scope visit(IfStatement ifState) {
        // TODO Auto-generated method stub
        System.out.println("ifstate");
        Scope type1 = ifState.f2.accept(this);
        System.out.println(type1.name());
        if(!(type1 == Bool.instance()))
            throw new Error("Non-boolean operand for \"if\".");
        System.out.println("-Going into if-statement");
        Scope type2 = ifState.f4.accept(this);
        System.out.println("-Going into else-statement");
        Scope type3 = ifState.f6.accept(this);
        return Bool.instance();
    }

    @Override
    public Scope visit(WhileStatement whileState) {
        // TODO Auto-generated method stub
        System.out.println("whilestate");
        Scope type1 = whileState.f2.accept(this);
        if(!(type1 == Bool.instance()))
            throw new Error("Non-boolean operand for \"while\".");
        return Bool.instance();
    }

    @Override
    public Scope visit(PrintStatement printState) {
        // TODO Auto-generated method stub
        System.out.println("printstate");
        Scope type1 = printState.f2.accept(this);
        if(!(type1 == Int.instance()))
            throw new Error("Non-Integer operand for PrintStatement. Type is: " + type1.name());
        return Int.instance();
    }

    @Override
    public Scope visit(Expression expression) {
        // TODO Auto-generated method stub
        System.out.println("expression");
        Scope type1 = expression.f0.accept(this);
        return type1;
    }

    @Override
    public Scope visit(AndExpression and) {
        // TODO Auto-generated method stub
        System.out.println("andexpression");
        Scope type1 = and.f0.accept(this);
        if(!(type1 == Bool.instance()))
            throw new Error("Non-boolean left operand for \"&&\".");
        Scope type2 = and.f0.accept(this);
        if(!(type2 == Bool.instance()))
            throw new Error("Non-boolean right operand for \"&&\".");
        return Bool.instance();
    }

    @Override
    public Scope visit(CompareExpression compare) {
        // TODO Auto-generated method stub
        System.out.println("compareexpression");
        Scope type1 = compare.f0.accept(this);
        if(!(type1 == Int.instance())){
            throw new Error("Non-integer left operand for \"<\".");
        }
        Scope type2 = compare.f2.accept(this);
        if(!(type2 == Int.instance())){
            throw new Error("Non-integer right operand for \"<\".");
        }
        return Bool.instance();
    }

    @Override
    public Scope visit(PlusExpression plus) {
        System.out.println("plus");
        Scope scope1 = plus.f0.accept(this);
        if(!(scope1 == Int.instance())){
            throw new Error("Non-integer left operand for \"+\".");
        }
        Scope scope2 = plus.f2.accept(this);
        if(!(scope2 == Int.instance())){
            throw new Error("Non-integer right operand for \"+\".");
        }
        return Int.instance();
    }

    @Override
    public Scope visit(MinusExpression minus) {
        // TODO Auto-generated method stub
        System.out.println("minus");
        Scope scope1 = minus.f0.accept(this);
        if(!(scope1 == Int.instance())){
            throw new Error("Non-integer left operand for \"-\".");
        }
        Scope scope2 = minus.f2.accept(this);
        if(!(scope2 == Int.instance())){
            throw new Error("Non-integer right operand for \"-\".");
        }
        return Int.instance();
    }

    @Override
    public Scope visit(TimesExpression times) {
        // TODO Auto-generated method stub
        System.out.println("timesexpression");
        Scope scope1 = times.f0.accept(this);
        if(!(scope1 == Int.instance())){
            throw new Error("Non-integer left operand for \"*\".");
        }
        System.out.println("====Looking at second operand now");
        Scope scope2 = times.f2.accept(this);
        if(!(scope2 == Int.instance())){
            throw new Error("Non-integer right operand for \"*\".");
        }
        return Int.instance();
    }

    @Override
    public Scope visit(ArrayLookup arrLook) {
        // TODO Auto-generated method stub
        System.out.println("arraylookup");
        Scope type1 = arrLook.f0.accept(this);
        if(!(type1 == ID.instance()))
            throw new Error("Non-ID for ArrayLookup.");
        Scope type2 = arrLook.f2.accept(this);
        if(!(type2 == Int.instance()))
            throw new Error("Non-integer for array index in ArrayLookup");
        return Int.instance();
    }

    @Override
    public Scope visit(ArrayLength n) {
        // TODO Auto-generated method stub
        System.out.println("arraylength");
        return Int.instance();
    }

    @Override
    public Scope visit(MessageSend message) {
        // TODO Auto-generated method stub
        System.out.println("messagesend");
        Scope scope1 = message.f0.accept(this);
        Scope scope2 = message.f2.accept(this);
        Scope scope3 = message.f4.accept(this);

        System.out.println(message.f2.f0.tokenImage);

        System.out.println("end messagesend");
        return scope2;
    }

    @Override
    public Scope visit(ExpressionList expList) {
        // TODO Auto-generated method stub
        System.out.println("expressionlist");
        expList.f0.accept(this);
        expList.f1.accept(this);
        return Int.instance();
    }

    @Override
    public Scope visit(ExpressionRest expRest) {
        // TODO Auto-generated method stub
        System.out.println("expressionrest");
        expRest.f1.accept(this);
        return Int.instance();
    }

    @Override
    public Scope visit(PrimaryExpression primaryExpression) {
        // TODO Auto-generated method stub
        System.out.println("primaryexpression");
        primaryExpression.f0.accept(this);
        System.out.println("end primaryexpression");
        return Int.instance();
    }

    @Override
    public Scope visit(IntegerLiteral intLit) {
        // TODO Auto-generated method stub
        System.out.println("integerliteral");
        Scope type1 = intLit.f0.accept(this);
        if(!(type1 == Int.instance()))
            throw new Error("Operand for IntegerLiteral is not an integer.");
        return Int.instance();
    }

    @Override
    public Scope visit(TrueLiteral trueLit) {
        // TODO Auto-generated method stub
        System.out.println("trueliteral");
        Scope type1 = trueLit.f0.accept(this);
        System.out.println(type1.name());
        if(!(type1 == Bool.instance()))
            throw new Error("Operand for TrueLiteral is not a boolean");
        return Bool.instance();
    }

    @Override
    public Scope visit(FalseLiteral falseLit) {
        // TODO Auto-generated method stub
        System.out.println("falseliteral");
        Scope type1 = falseLit.f0.accept(this);
        if(!(type1 == Bool.instance()))
            throw new Error("Operand for FalseLiteral is not a boolean");
        return Bool.instance();
    }

    @Override
    public Scope visit(Identifier ident) {
        // TODO Auto-generated method stub
        System.out.println("identifier: " + ident.f0);
        Scope type1 = ident.f0.accept(this);
        //type1.nameAdd(identifier.f0);
        Scope type2 = new ID(ident.f0.tokenImage);
        System.out.println("Testing the type1 under Identifier: " + type2.name());
        return type2;
    }

    @Override
    public Scope visit(ThisExpression thisExp) {
        // TODO Auto-generated method stub
        System.out.println("thisexpression");
        Scope scope1 = thisExp.f0.accept(this);
        return Int.instance();
    }

    @Override
    public Scope visit(ArrayAllocationExpression arrAllocationExp) {
        // TODO Auto-generated method stub
        System.out.println("arrayallocationexpression");
        arrAllocationExp.f3.accept(this);
        return Int.instance();
    }

    @Override
    public Scope visit(AllocationExpression allocExpression) {
        // TODO Auto-generated method stub
        System.out.println("allocationexpression");
        allocExpression.f1.accept(this);
        return Int.instance();
    }

    @Override
    public Scope visit(NotExpression notExp) {
        // TODO Auto-generated method stub
        System.out.println("notexpression");
        Scope type1 = notExp.f1.accept(this);
        if(!(type1 == Bool.instance()))
            throw new Error("Operand for NotExpression is not a boolean.");
        return type1;
    }

    @Override
    public Scope visit(BracketExpression bracketExp) {
        // TODO Auto-generated method stub
        System.out.println("bracketexpression");
        bracketExp.f1.accept(this);
        return Int.instance();
    }
}