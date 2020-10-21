package 剑指57_和为s的两个数字_双指针_哈希表_二分查找;

import java.util.Arrays;

class Solution {

    // 双指针写法
    // 有序数组的双指针，可以利用大小特性来移动指针
    public int[] twoSum(int[] nums, int target) {
        int p = 0;
        int q = nums.length -1;

        while(p<=q){
            if(nums[p] + nums[q] == target){
                int[] result = new int[2];
                result[0] = nums[p];
                result[1] = nums[q];
                return result;
            }
            else if (nums[p] + nums[q] < target){
                p++;
            }else {
                q--;
            }
        }

        int[] n = new int[0];
        return n;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] nums = {2,7,11,15};
        int k = 99;

        int[] result = s.twoSum(nums, k);

        System.out.println(Arrays.toString(result));
    }
}