package offersword;

import common.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 从尾到头打印链表
 * 想要把链表从尾到头输出，可以使用栈的先入后出特性，而栈有两种一种是数据结构的栈，另一种是程序堆栈（递归）。
 * 链表长度不一定，若太长使用递归会出现程序堆栈溢出，考虑到程序的鲁棒性，本题采用数据结构栈。
 * @author Yasin Zhang
 */
public class PrintFromTailToHead {
    public ArrayList<Integer> solution(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();

        recursiveToEnd(list, listNode);

        return list;
    }

    private void recursiveToEnd(ArrayList<Integer> list, ListNode listNode) {
        if (listNode == null) {
            return;
        }

        recursiveToEnd(list, listNode.next);
        list.add(listNode.val);
    }

    private ArrayList<Integer> solutionMoreRobust(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }

        Stack<Integer> stack = new Stack<>();
        ListNode curNode = listNode;
        while (curNode != null) {
            stack.push(curNode.val);
            curNode = curNode.next;
        }

        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }

        return list;
    }
}
