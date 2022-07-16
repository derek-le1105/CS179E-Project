package typeCheck;

import syntaxtree.*;

public class Int implements Scope{
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
