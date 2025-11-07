package com.szh.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. Copy List with Random Pointer (复制带随机指针的链表)
 * 
 * 题目链接：https://leetcode.cn/problems/copy-list-with-random-pointer/
 * 
 * 解法1：哈希表
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * 
 * 解法2：原地修改（最优解）
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution {
    
    class Node {
        int val;
        Node next;
        Node random;
        
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    
    /**
     * 解法1：哈希表
     * 使用哈希表存储原节点和复制节点的映射关系
     */
    public Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }
        
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        
        // 第一遍：创建所有节点
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        
        // 第二遍：连接next和random指针
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        
        return map.get(head);
    }
    
    /**
     * 解法2：原地修改（最优解）
     * 在每个原节点后面插入复制节点，然后设置random指针，最后分离两个链表
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        // 第一遍：在每个节点后面插入复制节点
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }
        
        // 第二遍：设置random指针
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        // 第三遍：分离两个链表
        curr = head;
        Node newHead = head.next;
        while (curr != null) {
            Node copy = curr.next;
            curr.next = copy.next;
            if (copy.next != null) {
                copy.next = copy.next.next;
            }
            curr = curr.next;
        }
        
        return newHead;
    }
}
