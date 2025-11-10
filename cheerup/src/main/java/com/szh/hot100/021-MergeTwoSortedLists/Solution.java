package com.szh.hot100;

/**
 * 021. Merge Two Sorted Lists (合并两个有序链表)
 * 
 * 题目链接：https://leetcode.cn/problems/merge-two-sorted-lists/
 * 
 * 解法1：迭代法
 * 时间复杂度：O(m + n)
 * 空间复杂度：O(1)
 * 
 * 解法2：递归法
 * 时间复杂度：O(m + n)
 * 空间复杂度：O(m + n)
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
     * 解法1：迭代法（推荐）
     * 使用虚拟头节点，逐个比较两个链表的节点
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        
        curr.next = (list1 != null) ? list1 : list2;
        
        return dummy.next;
    }
    
    /**
     * 解法2：递归法
     * 递归地合并两个链表
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists2(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists2(list1, list2.next);
            return list2;
        }
    }
}

