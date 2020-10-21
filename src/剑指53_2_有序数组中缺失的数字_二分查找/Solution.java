package 剑指53_2_有序数组中缺失的数字_二分查找;

class Solution {
    // 二分法直接优化思路
    public int missingNumber3(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (r >= l) {
            int mid = (l + r) / 2;
            if (nums[mid] == mid) { // 要转换一下二分的思路
                //如果中间元素索引相等，缺失的在右边，否则在左边
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }


    // 换种思路
    public int missingNumber2(int[] nums) {
        if (nums[0] != 0) return 0;
//        for (int i =0;i<nums.length-1;i++){
//            if (nums[i+1]-nums[i] != 1){
//                return nums[i]+1;
//            }
//        }

        // 这样最简洁，但是复杂度O(N)，二分直接优化思路O(logN)
        for (int i=0;i<nums.length;i++){
            if (nums[i] != i){
                return i;
            }
        }

        return nums.length;
    }


    boolean bisect(int[] nums, int key) {
        int low = 0, high = nums.length-1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] < key){
                low = mid+1;
            }else if(nums[mid] > key){
                high = mid -1;
            }else {
                return true;
            }
        }
        return false;
    }

    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (!bisect(nums, i)) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {0,1,2,4};

        int result = s.missingNumber2(nums);
        System.out.println(result);
    }
}