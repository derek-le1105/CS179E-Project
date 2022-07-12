package typeCheck;

import syntaxtree.*;

public class ID extends Type{
    private static ID ourInstance = new ID();

    public static ID instance(){
        return ourInstance;
    }

    private ID(){

    }

    public String name(){
        return "ID";
    }
}
