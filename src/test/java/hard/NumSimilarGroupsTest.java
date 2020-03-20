package hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class NumSimilarGroupsTest {

    @Test
    public void numSimilarGroups() {
        NumSimilarGroups alg = new NumSimilarGroups();
        String[] A = {"qihcochwmglyiggvsqqfgjjxu","gcgqxiysqfqugmjgwclhjhovi","gjhoggxvcqlcsyifmqgqujwhi","wqoijxciuqlyghcvjhgsqfmgg","qshcoghwmglygqgviiqfjcjxu","jgcxqfqhuyimjglgihvcqsgow","qshcoghwmggylqgviiqfjcjxu","wcoijxqiuqlyghcvjhgsqgmgf","qshcoghwmglyiqgvigqfjcjxu","qgsjggjuiyihlqcxfovchqmwg","wcoijxjiuqlyghcvqhgsqgmgf","sijgumvhqwqioclcggxgyhfjq","lhogcgfqqihjuqsyicxgwmvgj","ijhoggxvcqlcsygfmqgqujwhi","qshcojhwmglyiqgvigqfgcjxu","wcoijxqiuqlyghcvjhgsqfmgg","qshcojhwmglyiggviqqfgcjxu","lhogcgqqfihjuqsyicxgwmvgj","xscjjyfiuglqigmgqwqghcvho","lhggcgfqqihjuqsyicxgwmvoj","lhgocgfqqihjuqsyicxgwmvgj","qihcojhwmglyiggvsqqfgcjxu","ojjycmqshgglwicfqguxvihgq","sijvumghqwqioclcggxgyhfjq","gglhhifwvqgqcoyumcgjjisqx"};
        int result = alg.numSimilarGroups(A);
        System.out.println(result);
    }
}
