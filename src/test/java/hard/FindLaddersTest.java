package hard;

import org.junit.Test;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class FindLaddersTest {

    @Test
    public void findLadders() {
        FindLadders alg = new FindLadders();
        String beginWord = "a";
        String endWord = "c";
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        List<List<String>> ans = alg.findLadders(beginWord, endWord, list);
        System.out.println(ans);
    }

    @Test
    public void findLadders2() {
        FindLadders alg = new FindLadders();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");

        List<List<String>> ans = alg.findLadders(beginWord, endWord, list);
        System.out.println(ans);
    }
}
