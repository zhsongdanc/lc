package com.szh.hot100;

/**
 * 148. Sort List (排序链表)
 * 
 * 题目链接：https://leetcode.cn/problems/sort-list/
 * 
 * 解法：归并排序
 * 时间复杂度：O(n log n)
 * 空间复杂度：O(log n)
 */
public class Solution {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    /**
     * 最优解：归并排序
     * 使用快慢指针找到中点，然后递归排序左右两部分，最后合并
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        // 找到中点
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode mid = slow.next;
        slow.next = null;
        
        // 递归排序
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        
        // 合并
        return merge(left, right);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        curr.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}
