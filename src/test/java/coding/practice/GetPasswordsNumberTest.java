package coding.practice;

import org.junit.Test;

import static org.junit.Assert.*;

public class GetPasswordsNumberTest {

    @Test
    public void solution() {
        GetPasswordsNumber alg = new GetPasswordsNumber();
        int result = alg.solution("09");
        System.out.println(result);
    }
}
