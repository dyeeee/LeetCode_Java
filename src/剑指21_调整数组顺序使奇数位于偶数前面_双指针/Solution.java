package 剑指21_调整数组顺序使奇数位于偶数前面_双指针;



//输入：nums = [1,2,3,4]
//输出：[1,3,2,4]
//注：[3,1,2,4] 也是正确的答案之一。

import java.util.Arrays;

class Solution {
    //标准数组解法
    public int[] exchange(int[] nums) {
        int[] result = new int[nums.length];
        int[] tmp = new int[nums.length];
        int index = 0;
        int tmpIndex = 0;
        for (int num : nums) {
            if (num % 2 != 0){
                result[index] = num;
                index ++;

            }else {
                tmp[tmpIndex] = num;
                tmpIndex ++ ;
            }

        }

        for (int num:tmp){
            if (num !=0 ){
                result[index] = num;
                index ++;
            }
        }


        return result;
    }

    //双指针解法
    int[] exchange2(int[] nums){
        int i = 0, j = nums.length - 1, tmp;
        while(i < j) {
            while(i < j && (nums[i] % 2) == 1) i++;
            while(i < j && (nums[j] % 2) == 0) j--;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 3, 4};

        int[] result = s.exchange2(nums);

        System.out.println(Arrays.toString(result));
    }
}