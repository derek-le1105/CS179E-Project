package typeCheck;

import java.io.*;
import parser.*;
import syntaxtree.*;

public class typeCheckerLauncher {
    public static void processStream(InputStream stream){
        try{
            MiniJavaParser parser = new MiniJavaParser(stream);
            Goal root = parser.Goal();
            typeCheck typeChecker = new typeCheck(root);
            typeChecker.check();
            System.out.println("Program type checked successfully");
        }
        catch(Exception e){
            System.out.println("Type error.");
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        processStream(System.in);
    }
}
