package 剑指63_股票的最大利润_动态规划;


//输入: [7,1,5,3,6,4]
//        输出: 5
//        解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//        注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
//

//输入: [7,6,4,3,1]
//        输出: 0
//        解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

import java.util.Arrays;

class Solution {
    //题解
    //dp为前[i]日的最大利润，我自己想的是第i日一定抛出的最大利润
    //dp[i]前i日的最大利润 = max(i-1日的最大利润, 当前价格-前i日的最小价格)
    public int maxProfit3(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;  //初始利润为0
        for(int price : prices) {
            cost = Math.min(cost, price);  //记录最低价格
            profit = Math.max(profit, price - cost);  //一边动态规划一边得出结果
            // 这里只需要profit，不需要存储每一天的
        }
        return profit;
    }


    //自我优化动态规划，还可以，时间还是慢了一点
    int maxProfit2(int[] prices){
        // 边界的可能性，能不能进入dp之类的
        if(prices.length == 0 || prices.length == 1){
            return 0;
        }else if (prices.length == 2){
            return Math.max(0,prices[1]-prices[0]);
        }

        int result = 0;
        //第i天卖出的最高利润
        int[] dp = new int[prices.length];
        // 第一天不能卖出
        dp[0] = 0;
        //dp[1] = prices[1] - prices[0];

        for (int i = 1;i<prices.length;i++){
            dp[i] = Math.max(dp[i-1]+prices[i]-prices[i-1],prices[i]-prices[i-1]);
            result = Math.max(result,dp[i]);
        }
        //Arrays.sort(dp);
        return result;
    }

    // 动态规划
    // 有点捞，时间5%，不是很动态规划，本质还是双循环
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }

        //第i天卖出的最高利润
        int[] dp = new int[prices.length];

        // 第一天不能卖出
        dp[0] = 0;
        for (int i =1;i<prices.length;i++){
            int tmpMax = 0;
            for (int j=0;j<i;j++){
                tmpMax = Math.max(prices[i]-prices[j],tmpMax);
            }
            dp[i] = tmpMax;
            //System.out.println(Arrays.toString(dp));
        }
        Arrays.sort(dp);
        return dp[prices.length-1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,4,2};

        int result = s.maxProfit2(nums);
        System.out.println(result);
    }
}