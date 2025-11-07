package com.szh.hot100;

/**
 * 002. Add Two Numbers (两数相加)
 * 
 * 题目链接：https://leetcode.cn/problems/add-two-numbers/
 * 
 * 解法：模拟加法过程
 * 时间复杂度：O(max(m, n))，其中 m 和 n 分别为两个链表的长度
 * 空间复杂度：O(1)（不考虑返回值的空间）
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
     * 最优解：模拟加法过程
     * 同时遍历两个链表，逐位相加，处理进位
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // 虚拟头节点
        ListNode curr = dummy;
        int carry = 0; // 进位
        
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }
        
        return dummy.next;
    }
}

