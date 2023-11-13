package linkedlist;

/*
 * @Author: demussong
 * @Description:
 * 给你一个链表数组，每个链表都已经按升序排列。

请你将所有链表合并到一个升序链表中，返回合并后的链表
 * @Date: 2023/8/20 10:05
 */
public class S23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int l, int r) {
        if (l >= r) {
            return lists[l];
        }

        int mid = (l + r) >>> 1;
        ListNode left = mergeKLists(lists, l, mid);
        ListNode right = mergeKLists(lists, mid + 1, r);
        return mergeTwoList(left, right);

    }

    /**
     *
     * @param l1
     * @param l2
     * @return the head of the merged list
     */
    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode iterator = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                iterator.next = l1;
                l1 = l1.next;
                iterator = iterator.next;
            }else {
                iterator.next = l2;
                l2 = l2.next;
                iterator = iterator.next;
            }
        }

        while (l1 != null) {
            iterator.next = l1;
            l1 = l1.next;
            iterator = iterator.next;
        }
        while (l2 != null) {
            iterator.next = l2;
            l2 = l2.next;
            iterator = iterator.next;
        }

        return head.next;
    }

}
