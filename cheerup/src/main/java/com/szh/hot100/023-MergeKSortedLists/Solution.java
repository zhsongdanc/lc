package com.szh.hot100;

import java.util.PriorityQueue;

/**
 * 023. Merge k Sorted Lists (合并K个升序链表)
 * 
 * 题目链接：https://leetcode.cn/problems/merge-k-sorted-lists/
 * 
 * 解法1：分治法
 * 时间复杂度：O(kn * log k)
 * 空间复杂度：O(log k)
 * 
 * 解法2：优先队列（最小堆）
 * 时间复杂度：O(kn * log k)
 * 空间复杂度：O(k)
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
     * 解法1：分治法（推荐）
     * 将k个链表两两合并，直到合并成一个链表
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }
    
    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
    
    /**
     * 解法2：优先队列（最小堆）
     * 使用优先队列维护所有链表的当前最小节点
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // 将所有链表的头节点加入优先队列
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;
            
            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        
        return dummy.next;
    }
}

