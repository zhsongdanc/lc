package com.demus.standard;

public class S29 {
    class Solution {
        public int divide(int dividend, int divisor) {
            // 处理唯一会溢出的情况
            if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            }

            // 确定商的符号（异号为负）
            boolean isNegative = (dividend < 0) ^ (divisor < 0);

            // 转为负数计算（避免正数溢出，因为负数范围比正数大1）
            int dividendAbs = dividend > 0 ? -dividend : dividend;
            int divisorAbs = divisor > 0 ? -divisor : divisor;

            int quotient = 0;

            // 当被除数的绝对值 >= 除数的绝对值时，继续计算
            while (dividendAbs <= divisorAbs) {
                // 当前减去除数的倍数（初始为1）
                int multiple = 1;
                // 当前要减去的量（初始为除数）
                int subtract = divisorAbs;

                // 找到最大的subtract，使得subtract*2仍 <= 被除数（避免溢出）
                // 每次翻倍（等价于乘以2）
                while (dividendAbs <= subtract + subtract && subtract + subtract < 0) {
                    subtract += subtract; // 翻倍（相当于乘2）
                    multiple += multiple; // 倍数也翻倍
                }

                // 减去当前最大的subtract，并累加倍数到商
                dividendAbs -= subtract;
                quotient += multiple;
            }

            // 根据符号返回结果
            return isNegative ? -quotient : quotient;
        }
    }

}
