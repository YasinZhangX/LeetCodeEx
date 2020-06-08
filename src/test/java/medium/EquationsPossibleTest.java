package medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class EquationsPossibleTest {

    @Test
    public void equationsPossible() {
        EquationsPossible alg = new EquationsPossible();
        String[] equations = {"a==b", "b!=a"};
        System.out.println(alg.equationsPossible(equations));
    }
}
