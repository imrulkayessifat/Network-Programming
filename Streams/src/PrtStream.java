
import java.io.FileNotFoundException;
import java.io.PrintStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author imrul
 */
public class PrtStream {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream out = new PrintStream("example8.txt");
        int var1 = 10;
        out.println(var1);
        out.close();
    }
}
