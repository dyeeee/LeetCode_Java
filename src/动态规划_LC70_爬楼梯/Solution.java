package 动态规划_LC70_爬楼梯;

//每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶

// 思路：dp[n]存储去到每个台阶有多少种
// dp[1] = 1; dp[2] = 2; dp[n] = dp[n-1] + dp[n-2] 走两步到第n台阶或者走一步到
// 走到dp[n] 可以通过 dp[n-1]+1 或者dp[n-2]+2
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        if (n < 2) {
            dp[0] = 0;
            dp[1] = 1;
            return dp[n];
        } else {
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int nums = 1;

        int result = s.climbStairs(nums);
        System.out.println(result);
    }
}