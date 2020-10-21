package 剑指56_数组中的不重复数字_位运算;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


//数组中有两个数字是不重复的，用O(N),O(1)找出来
class Solution {

    // 哈希表思路
    public int[] singleNumbers(int[] nums) {
        int numsToFind = 2;
        int[] result = new int[2];
        ArrayList<Integer> repeatNums= new ArrayList<>();
        HashSet<Integer> hset = new HashSet<>();
        for(int num:nums){
            if(!hset.add(num)){
                repeatNums.add(num);
            }
        }

        for (int num:nums){
            if (!repeatNums.contains(num)){
                result[numsToFind-1] = num;
                numsToFind --;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,4,6};
        Solution s = new Solution();

        int[] result = s.singleNumbers(nums);
        System.out.println(Arrays.toString(result));
    }
}