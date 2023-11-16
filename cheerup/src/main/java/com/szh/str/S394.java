package com.szh.str;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/11/14 16:38
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 *
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 *
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 *
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 30
 * s 由小写英文字母、数字和方括号 '[]' 组成
 * s 保证是一个 有效 的输入。
 * s 中所有整数的取值范围为 [1, 300]
 */
public class S394 {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        Deque<Integer> digitStack  = new ArrayDeque<Integer>();
        Deque<String> strStack = new ArrayDeque<>();

        StringBuilder curStr = new StringBuilder();
        int dup = 0;
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                curStr.append(c);
            }else if (c == '[') {
                digitStack.push(dup);
                dup = 0;
                strStack.push(curStr.toString());
                curStr = new StringBuilder();
            }else if (c == ']') {
                int twice = digitStack.pop();
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < twice; i++) {
                    builder.append(curStr);
                }
                curStr = new StringBuilder(strStack.pop() + builder.toString());
            } else if (c >= '0' && c <= '9') {
                dup = dup*10 + (c - '0');
            }else {
                throw new IllegalArgumentException("输入不合法");
            }
        }
        return curStr.toString();
    }

    public static void main(String[] args) {
        String str = "ad3[b]3[r4[dfae3[bb]woio]ae]";


        String s = new S394().decodeString(str);

        System.out.println(s);
    }
}
