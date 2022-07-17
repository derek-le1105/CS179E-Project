import java.io.*;
import syntaxtree.Goal;

public class typeCheckerLauncher {
    public static void processStream(InputStream stream){
        try{
            new MiniJavaParser(stream);
            Goal root = MiniJavaParser.Goal();
            typeCheck typeChecker = new typeCheck(root);
            //typeChecker.check(root);
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
