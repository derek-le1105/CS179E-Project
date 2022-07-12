package typeCheck;

import syntaxtree.*;

public class Boolean extends Type{
    private static Boolean ourInstance = new Boolean();

    public static Boolean instance(){
        return ourInstance;
    }

    private Boolean(){

    }

    public String name(){
        return "Boolean";
    }
}
