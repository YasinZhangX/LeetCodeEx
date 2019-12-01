package hard;

import common.ListNode;
import easy.MergeTwoList;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Yasin Zhang
 *
 * solution1 通过朴素算法，在原list上进行合并，每次比较获取一个最小值
 * solution2 通过优先队列进行自动比较
 * solution3 通过分治算法，递归每次合并两个list
 */
public class MergeKLists {
    public ListNode solution(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        boolean initiatedMin = false;
        Set<Integer> nullNodeInLists = new HashSet<>();
        int min = 0;
        for(int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                if (!initiatedMin) {
                    min = i;
                    initiatedMin = true;
                }
                if (lists[i].val < lists[min].val) {
                    min = i;
                }
            } else {
                nullNodeInLists.add(i);
            }
        }

        if (nullNodeInLists.size() == lists.length) {
            return null;
        }

        ListNode headNode = lists[min];
        ListNode curNode = lists[min];
        lists[min] = lists[min].next;
        initiatedMin = false;
        while(nullNodeInLists.size() != lists.length) {
            for(int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (!initiatedMin) {
                        min = i;
                        initiatedMin = true;
                    } else {
                        if (lists[i].val < lists[min].val) {
                            min = i;
                        }
                    }
                } else {
                    nullNodeInLists.add(i);
                }
            }

            curNode.next = lists[min];
            curNode = lists[min];
            if (lists[min] != null) {
                lists[min] = lists[min].next;
            }
            initiatedMin = false;
        }

        return headNode;
    }

    public ListNode solution2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }
        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if (p.next != null) queue.add(p.next);
        }
        return dummy.next;
    }

    public ListNode solution3(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        MergeTwoList alg = new MergeTwoList();
        return alg.mergeTwoLists(l1, l2);
    }

}
