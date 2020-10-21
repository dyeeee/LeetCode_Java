package 剑指59_滑动窗口的最大值_滑动窗口;

//输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//        输出: [3,3,5,5,6,7]
//        解释:
//
//        滑动窗口的位置                最大值
//        ---------------               -----
//        [1  3  -1] -3  5  3  6  7       3
//        1 [3  -1  -3] 5  3  6  7       3
//        1  3 [-1  -3  5] 3  6  7       5
//        1  3  -1 [-3  5  3] 6  7       5
//        1  3  -1  -3 [5  3  6] 7       6
//        1  3  -1  -3  5 [3  6  7]      7

import java.util.Arrays;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length==0){
            return nums;
        }

        int[] result = new int[nums.length - k + 1];
        int index = 0;
        int i = 0, j = i + k - 1;

        while (j < nums.length) {

            int curMax = nums[i];
            int tmp = i;
            while (tmp < j) {
                curMax = Math.max(curMax, nums[tmp + 1]);
                tmp++;
            }
            result[index] = curMax;
            index ++;
            i ++;
            j ++;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] result = s.maxSlidingWindow(nums, k);

        System.out.println(Arrays.toString(result));
    }
}