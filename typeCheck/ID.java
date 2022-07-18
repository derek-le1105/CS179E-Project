package typeCheck;

import syntaxtree.*;

public class ID implements Scope{
    String str;
    String typeHold;
    private static ID ourInstance = new ID();

    public static ID instance(){
        return ourInstance;
    }

    public ID(){

    }

    public ID(String s){
        str = s;
    }

    public ID(String id, String type){
        str = id; 
        typeHold = type;
    }

    public String name(){
        return str;
    }

    public void nameAdd(String s){
        str = s;
    }
}
