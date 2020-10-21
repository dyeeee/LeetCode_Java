package 剑指53_有序数组中数字出现次数_二分查找;


// 一看到有序数组就要想到二分查找
// 递归和非递归二分
class Solution {
    int count = 0;

    int bisectR(int[] arr, int key, int low,int high){
        if (low <= high) {

            //初始中间位置
            int middle = (low + high) / 2;

            if (arr[middle] > key) {
                //比关键字大则关键字在左区域
                return bisectR(arr, key, low, middle - 1);
            } else if (arr[middle] < key) {
                //比关键字小则关键字在右区域
                return bisectR(arr, key, middle + 1, high);
            } else {
                //找到则计数
                count++;      // 计数一次
                bisectR(arr, key, low, middle - 1);
                bisectR(arr, key, middle + 1, high);

                return middle;
            }
        }else
        {return -1;}
    }

    public int search(int[] nums, int target) {
            bisectR(nums,target,0,nums.length-1);
            return count;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] nums = {1};
        int target = 1;

        int result = s.search(nums,target);
        System.out.println(result);
    }
}