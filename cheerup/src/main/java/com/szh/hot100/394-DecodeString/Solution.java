package com.szh.hot100;

import java.util.Stack;

/**
 * 394. Decode String (字符串解码)
 * 
 * 题目链接：https://leetcode.cn/problems/decode-string/
 * 
 * 解法：栈
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Solution {
    
    /**
     * 最优解：栈
     * 使用两个栈分别存储数字和字符串
     */
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        String currentString = "";
        int num = 0;
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                numStack.push(num);
                strStack.push(currentString);
                num = 0;
                currentString = "";
            } else if (c == ']') {
                int repeatTimes = numStack.pop();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < repeatTimes; i++) {
                    sb.append(currentString);
                }
                currentString = strStack.pop() + sb.toString();
            } else {
                currentString += c;
            }
        }
        
        return currentString;
    }
}
