package 剑指40_最小的k个数_分治;

//输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]

import java.util.Arrays;

public class Solution {

    //直接排序做了，应该有更好的方法
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] result = new int[k];
        for (int i=0;i<k;i++){
            result[i] = arr[i];
        }
        return result;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] nums = {3,2,1};
        int k = 2;

        int[] result = s.getLeastNumbers(nums,k);
        System.out.println(Arrays.toString(result));

    }
}
