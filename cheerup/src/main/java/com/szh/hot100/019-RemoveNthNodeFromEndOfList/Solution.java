package com.szh.hot100;

/**
 * 019. Remove Nth Node From End of List (删除链表的倒数第N个结点)
 * 
 * 题目链接：https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * 
 * 解法：双指针法（快慢指针）
 * 时间复杂度：O(L)，其中 L 是链表的长度
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
     * 最优解：双指针法
     * 使用快慢指针，快指针先走 n+1 步，然后快慢指针同时移动
     * 当快指针到达末尾时，慢指针指向要删除节点的前一个节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // 快指针先走 n+1 步
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // 快慢指针同时移动
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // 删除节点
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}

