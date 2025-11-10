package com.szh.hot100;

/**
 * 876. Middle of the Linked List (链表的中间结点)
 * 
 * 题目链接：https://leetcode.cn/problems/middle-of-the-linked-list/
 * 
 * 解法：快慢指针
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
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
     * 最优解：快慢指针
     * 快指针每次移动两步，慢指针每次移动一步，当快指针到达末尾时，慢指针指向中间节点
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}
