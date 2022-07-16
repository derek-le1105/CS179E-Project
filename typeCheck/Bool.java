package typeCheck;

import syntaxtree.*;

public class Bool implements Scope{
    private static Bool ourInstance = new Bool();

    public static Bool instance(){
        return ourInstance;
    }

    private Bool(){
        super();

    }

    public String name(){
        return "Boolean";
    }
}
