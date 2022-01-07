package 滑动窗口_209_长度最小的子数组;


//给定一个含有n个正整数的数组和一个正整数 target 。
//        找出该数组中满足其和 ≥ target 的长度最小的 连续子数组
//        [numsl, numsl+1, ..., numsr-1, numsr] ，
//        并返回其长度。如果不存在符合条件的子数组，返回 0 。
//
//
//        示例 1：
//        输入：target = 7, nums = [2,3,1,2,4,3]
//        输出：2
//        解释：子数组[4,3]是该条件下的长度最小的子数组。
//
//        示例 2：
//        输入：target = 4, nums = [1,4,4]
//        输出：1


public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 0;
        int n = nums.length;
        int sum = 0;
        int result = 1000001;

        while(r<n){
            System.out.print(l);
            System.out.print(" ");
            System.out.print(r);


            for (int i = l; i <= r; i++) {

                sum += nums[i];
            }

            System.out.print(" ");
            System.out.print(sum);
            System.out.println();

            if (sum<target){
                r += 1;
            }else if (sum>=target){
                result = Math.min(result, r-l+1);
                l += 1;
            }
            sum = 0;
        }

        if (result == 1000001){
            return  0 ;
        }else {

            return result;
        }

    }

    public int minSubArrayLen_ans(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }



    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,3,4,5};
        int target = 11;

        int result = s.minSubArrayLen(target,nums);
        System.out.println(result);

    }

}
