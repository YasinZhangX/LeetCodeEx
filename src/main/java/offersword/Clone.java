package offersword;

import common.RandomListNode;

/**
 * 复杂链表的复制
 * @author Yasin Zhang
 */
public class Clone {
    public RandomListNode solution(RandomListNode pHead)
    {
        if (pHead == null) {
            return null;
        }

        RandomListNode curNode = pHead;
        while (curNode != null) {
            RandomListNode newNode = new RandomListNode(curNode.label);
            RandomListNode nextNode = curNode.next;
            curNode.next = newNode;
            newNode.next = nextNode;
            curNode = nextNode;
        }

        curNode = pHead;
        while (curNode != null) {
            if (curNode.random != null) {
                curNode.next.random = curNode.random.next;
            }

            curNode = curNode.next.next;
        }

        RandomListNode dumpHead = new RandomListNode(0);
        dumpHead.next = pHead.next;
        curNode = pHead;
        while (curNode != null) {
            RandomListNode nextNode = curNode.next.next;
            RandomListNode newNode = curNode.next;
            if (nextNode != null) {
                newNode.next = nextNode.next;
            } else {
                newNode.next = null;
            }
            curNode.next = nextNode;
            curNode = nextNode;
        }

        return dumpHead.next;
    }
}
