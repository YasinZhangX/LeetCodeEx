package tools;

import java.io.InputStream;
import java.util.Scanner;

import static tools.Print.*;

/**
 * @author Yasin Zhang
 * @version 1.0
 */
public class ConsoleInput extends Input {   
    public ConsoleInput(InputStream source) {
        this.sc = new Scanner(source);
    }
    
    public Boolean getAnswer() {
        Boolean ret = false;
        int count = 0;
        
        while (true) {
            String input = sc.nextLine();
            String str = input.toLowerCase().trim();
            if (str.equals("yes")) {
                ret = true;
                break;
            } else if (str.equals("no")) {
                ret = false;
                break;
            } else {
                eprint("Input Error! Please input \"yes\" or \"no\".");
                count++;
                if (count > 3) {
                    eprint("Are you kidding me? Bye");
                    System.exit(-1);
                }
            }
        }
        
        return ret;
    }
}
