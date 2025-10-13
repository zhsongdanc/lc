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

    /**
     * 核心优化点：倍增减法普通减法每次只减一个除数，而倍增法每次尝试减「当前除数的 2 倍、4 倍、8 倍...」，直到再翻倍就会超过被除数为止。例如计算 100 ÷ 3：
     * 第一次减 3×32=96（32 是最大倍数），剩余 4，商 +=32
     * 第二次减 3×1=3，剩余 1，商 +=1
     * 总次数从 33 次减法减少到 2 次，效率极大提升。
     * 为什么用负数计算？因为 Java 中 32 位整数的范围是 [-2³¹, 2³¹-1]，负数的最小值（-2³¹）无法用正数表示（最大正数是 2³¹-1）。统一用负数计算可以避免溢出。
     * 边界处理细节
     * subtract + subtract < 0 确保翻倍后不会溢出（负数翻倍后仍为负数，若溢出会变成正数）
     * 唯一需要单独处理的溢出情况：dividend = -2³¹ 且 divisor = -1，此时结果为 2³¹，超过范围，返回 2³¹-1
     * 通过这种方式，减法次数从「商的大小」减少到「log (商)」，例如商为 1000 时，只需约 10 次减法（2^10=1024），时间复杂度降至 O (log n)，同时代码逻辑依然清晰易懂。
     */
}
