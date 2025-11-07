package com.szh.hot100;

/**
 * 142. Linked List Cycle II (环形链表 II)
 * 
 * 题目链接：https://leetcode.cn/problems/linked-list-cycle-ii/
 * 
 * 解法：快慢指针（Floyd判圈算法）
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    /**
     * 最优解：快慢指针（Floyd判圈算法）
     * 1. 使用快慢指针找到相遇点
     * 2. 将其中一个指针移到头节点，两个指针同时移动，相遇点即为环的入口
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        // 找到相遇点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        
        if (fast == null || fast.next == null) {
            return null;
        }
        
        // 找到环的入口
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
}
