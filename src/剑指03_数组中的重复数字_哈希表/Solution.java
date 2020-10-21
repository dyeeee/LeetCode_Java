package 剑指03_数组中的重复数字_哈希表;

import java.util.HashSet;

class Solution {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> h = new HashSet();
        for (int num : nums) {
            if (!h.contains(num)) {
                h.add(num);
            } else {
                return num;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2, 3, 1, 0, 2, 5, 3};

        int result = s.findRepeatNumber(nums);
        System.out.println(result);
    }


}