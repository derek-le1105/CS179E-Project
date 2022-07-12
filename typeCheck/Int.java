package typeCheck;

import syntaxtree.*;

public class Int extends Type{
    private static Int ourInstance = new Int();

    public static Int instance(){
        return ourInstance;
    }

    private Int(){
    }

    public String name(){
        return "Int";
    }
}
