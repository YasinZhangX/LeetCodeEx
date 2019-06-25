package Utils;

import java.io.PrintStream;

public class Print {
    // Print with a newline:
    public static void print(Object obj) {
      System.out.println(obj);
    }
    
    // Print a newline by itself:
    public static void print() {
      System.out.println();
    }
    
    // Print with no line break:
    public static void printnb(Object obj) {
      System.out.print(obj);
    }
    
    // The new Java SE5 printf() (from C):
    public static PrintStream
    printf(String format, Object... args) {
      return System.out.printf(format, args);
    }
    
    // Print error with a newline:
    public static void eprint(Object obj) {
      System.err.println(obj);
    }
    
    // Print int array with a newline:
    public static void printInt(int[] a) {
        printnb('[');
        for (int i = 0; i < a.length; i++) {
            int j = a[i];
            printnb(j);
            if (i != a.length-1) {
                printnb(", ");
            }
        }
        print(']');
    }
}
