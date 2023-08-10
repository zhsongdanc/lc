package dp;

/**
 * @author demussong
 * @describe
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 *
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 *
 * 假设每一种面额的硬币有无限个。
 *
 * 题目数据保证结果符合 32 位带符号整数。
 * @date 2023/8/9 22:26
 */
public class S518 {
    public int change(int amount, int[] coins) {
        // dp[i] = dp[i] + dp[i - coin]
        if (coins == null) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        // 凑出总金额为0的组合数有1种
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin;i <= amount; i++) {
                dp[i] = dp[i] + dp[i - coin];
            }
        }
        return dp[amount];
    }
}
