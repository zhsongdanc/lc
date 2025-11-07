package com.szh.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. Linked List Cycle (环形链表)
 * 
 * 题目链接：https://leetcode.cn/problems/linked-list-cycle/
 * 
 * 解法1：哈希表
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * 
 * 解法2：快慢指针（Floyd判圈算法）
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
     * 解法1：哈希表
     * 使用Set记录访问过的节点
     */
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (visited.contains(head)) {
                return true;
            }
            visited.add(head);
            head = head.next;
        }
        return false;
    }
    
    /**
     * 解法2：快慢指针（Floyd判圈算法）（最优解）
     * 使用两个指针，一个快指针每次移动两步，一个慢指针每次移动一步
     * 如果存在环，快指针最终会追上慢指针
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return true;
    }
}

