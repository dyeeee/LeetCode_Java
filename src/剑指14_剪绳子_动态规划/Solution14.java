package 剑指14_剪绳子_动态规划;
//例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
//边界条件：dp[1] = dp[2] = 1，表示长度为 2 的绳子最大乘积为 1；
//状态转移方程：dp[i] = max(dp[i], max((i - j) * j, j * dp[i - j]))

class Solution14 {
    int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1; //长度为 2 的绳子最大乘积为 1；
        for (int i = 3; i < n + 1; i++) { // 长度为i的绳子的剪法
            for (int j = 1; j < i; j++) { // 从j=1开始尝试剪
                //dp[3] = max(dp[3],max((3-1)*1<剪成j长两段直接乘>, 1*dp[3-1]<剪出j的长度和i-j的最长长度相乘>)
                // j * dp[i - j]<剪出j的长度和i-j的最长长度相乘> 不用管dp[i-j]是怎么剪的
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, j * dp[i - j]));
                //括号里面还要有一个dp[i]是因为每一个dp[i]都是一个j下面的
                //随着j更新，dp[i]也需要更新
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        Solution14 s = new Solution14();
        int result = s.cuttingRope(8);
        System.out.println(result);
    }
}



