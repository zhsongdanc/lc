package com.szh.hot100;

/**
 * 234. Palindrome Linked List (回文链表)
 * 
 * 题目链接：https://leetcode.cn/problems/palindrome-linked-list/
 * 
 * 解法：快慢指针 + 反转链表
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
     * 最优解：快慢指针 + 反转链表
     * 1. 使用快慢指针找到中点
     * 2. 反转后半部分链表
     * 3. 比较前后两部分
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        // 找到中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // 反转后半部分
        ListNode secondHalf = reverseList(slow.next);
        
        // 比较前后两部分
        ListNode firstHalf = head;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        
        return true;
    }
    
    private ListNode reverseList(ListNode head) {
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
}
