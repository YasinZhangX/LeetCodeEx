package offersword;

import common.RandomListNode;
import org.junit.Test;

/**
 * @author Yasin Zhang
 */
public class CloneTest {

    @Test
    public void solution() {
        RandomListNode l1 = new RandomListNode(1);
        RandomListNode l2 = new RandomListNode(2);
        RandomListNode l3 = new RandomListNode(3);
        RandomListNode l4 = new RandomListNode(4);
        RandomListNode l5 = new RandomListNode(5);
        l1.next = l2;
        l1.random = l3;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.random = l2;
        
        Clone alg = new Clone();
        RandomListNode head = alg.solution(l1);

        RandomListNode curNode = l1;
        while (curNode != null) {
            System.out.print(curNode + " ");
            curNode = curNode.next;
        }

        System.out.println();

        curNode = head;
        while (curNode != null) {
            System.out.print(curNode + " ");
            curNode = curNode.next;
        }
    }
}
