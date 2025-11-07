package com.szh.hot100;

/**
 * 206. Reverse Linked List (反转链表)
 * 
 * 题目链接：https://leetcode.cn/problems/reverse-linked-list/
 * 
 * 解法1：迭代
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * 
 * 解法2：递归
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
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
     * 解法1：迭代（推荐）
     * 使用三个指针：prev, curr, next
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    /**
     * 解法2：递归
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        
        return newHead;
    }
}

