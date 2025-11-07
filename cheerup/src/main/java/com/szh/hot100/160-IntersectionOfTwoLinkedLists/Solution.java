package com.szh.hot100;

/**
 * 160. Intersection of Two Linked Lists (相交链表)
 * 
 * 题目链接：https://leetcode.cn/problems/intersection-of-two-linked-lists/
 * 
 * 解法：双指针
 * 时间复杂度：O(m + n)
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
     * 最优解：双指针
     * 两个指针分别从两个链表头开始，到达末尾后交换到另一个链表头
     * 如果两个链表相交，两个指针会在交点相遇
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        
        ListNode pA = headA;
        ListNode pB = headB;
        
        while (pA != pB) {
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }
        
        return pA;
    }
}
