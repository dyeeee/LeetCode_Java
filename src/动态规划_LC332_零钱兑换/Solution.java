package 动态规划_LC332_零钱兑换;

//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
//        如果没有任何一种硬币组合能组成总金额，返回-1。
//        你可以认为每种硬币的数量是无限的。

//        示例1：
//        输入：coins = [1, 2, 5], amount = 11
//        输出：3
//        解释：11 = 5 + 5 + 1

//        示例 2：
//        输入：coins = [2], amount = 3
//        输出：-1


import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i>=coins[j] && dp[i - coins[j]] != 10001){
                    // i-coins[j]的位置已经有更新过的解，遍历每个可能的硬币选择找出最小的
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i]);
            System.out.print(" ");
        }
        System.out.println("");

        if (dp[amount] != 10001){
            return dp[amount];
        }
        else {
            return  -1;
        }


    }

    public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = {1,2,5};

    int result = s.coinChange(nums, 11);
    System.out.println(result);
    }
}