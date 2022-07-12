package typeCheck;

import syntaxtree.*;

public class Array {
    private static Array ourInstance = new Array();

    public static Array instance(){
        return ourInstance;
    }

    private Array(){

    }

    public String name(){
        return "Array";
    }
}
