package 剑指39_数组中出现次数超过一半的数字_哈希表;

import java.util.Arrays;
import java.util.HashMap;


// 一个数组中有一个数字出现次数超过长度的一半，找出来
class Solution {

    // 哈希表解法， O(N)复杂度，注意长度为1单独处理
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        if(nums.length == 1){
            return nums[0];
        }

        for (int num:nums) {
            if (!map.containsKey(num)){
                map.put(num,1);
            }else {
                // 一边记录次数一边判断有没有超过一半
                int cur = map.get(num)+1;
                map.put(num,cur);

                if (cur>(nums.length/2)) return num;
            }
        }

        //System.out.println(map);
        return 0;
    }

    // 超过一半的数排序完之后一定在中间
    public int majorityElement_sort(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }

        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    // 摩尔排序法（找超过一半的数字的方法）


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 2, 3, 2};

        int result = s.majorityElement_sort(nums);
        System.out.println(result);
    }
}