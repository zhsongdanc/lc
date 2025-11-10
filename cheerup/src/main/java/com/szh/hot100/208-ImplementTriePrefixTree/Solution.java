package com.szh.hot100;

/**
 * 208. Implement Trie (Prefix Tree) (实现 Trie (前缀树))
 * 
 * 题目链接：https://leetcode.cn/problems/implement-trie-prefix-tree/
 * 
 * 解法：Trie树
 * 时间复杂度：插入和搜索都是 O(m)，其中 m 是字符串长度
 * 空间复杂度：O(ALPHABET_SIZE * N * M)，其中 N 是键的数量，M 是键的长度
 */
public class Solution {
    
    class Trie {
        class TrieNode {
            TrieNode[] children;
            boolean isEnd;
            
            TrieNode() {
                children = new TrieNode[26];
                isEnd = false;
            }
        }
        
        private TrieNode root;
        
        public Trie() {
            root = new TrieNode();
        }
        
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }
        
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd;
        }
        
        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }
        
        private TrieNode searchPrefix(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    return null;
                }
                node = node.children[index];
            }
            return node;
        }
    }
}
