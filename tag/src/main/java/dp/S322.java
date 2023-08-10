package dp;

/**
 * @author demussong
 * @version 1.0
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 * @date 2023/8/8 22:47
 */
public class S322 {
    // dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i - 1]] - 1)
    public int coinChange(int[] coins, int amount) {

        if (amount == 0 || coins == null) return 0;


        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (i == coin) {
                    dp[i] = 1;
                }else if (dp[i - coin] != 0 && dp[i] != 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }else if (dp[i -coin] != 0) {
                    dp[i] = dp[i - coin] + 1;
                }
            }
        }
        return dp[amount] == 0 ? -1:dp[amount];

    }
}
