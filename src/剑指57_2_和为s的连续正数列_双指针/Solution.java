package 剑指57_2_和为s的连续正数列_双指针;

// 输入一个正整数 target ，
// 输出所有和为 target 的连续正整数序列（至少含有两个数）。
//
// 输入：target = 15
// 输出：[[1,2,3,4,5],[4,5,6],[7,8]]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    int sumHelper(int[] nums, int low,int high){
        int sum = 0;
        for (int i=low;i<=high;i++){
            sum += nums[i];
        }
        return sum;
    }

    // 自己想的双指针思路还行，但是要优化
    // List对象、ArrayList对象的学习
    public int[][] findContinuousSequence2(int target) {
        List<int[]> vec = new ArrayList<int[]>();
        // 不一定要确定上界
        for (int l = 1, r = 2; l < r;) {
            // 用等差数列求和, 也不需要新开数组
            int sum = (l + r) * (r - l + 1) / 2;

            if (sum == target) {
                int[] res = new int[r - l + 1];
                for (int i = l; i <= r; ++i) {
                    res[i - l] = i;
                }
                vec.add(res);
                l++;
                r++;
            } else if (sum < target) {
                r++;
            } else {
                l++;
            }
        }
        for (int [] nums:vec
             ) {
            System.out.println(Arrays.toString(nums));
        }

        return vec.toArray(new int[vec.size()][]);
    }


    // 分析一波
    // 偶数最大的是 t/2
    // 奇数最大的就是 t/2 和 t/2 + 1
    public int[][] findContinuousSequence(int target) {
        int maxNum = target / 2 + 1;
        int[] arr = new int[maxNum];
        int p = 0;int q = 1;

        List<int[]> vec = new ArrayList<int[]>();

        for(int i=0;i<maxNum;i++){
            arr[i] = i+1;
        }

        while(q<maxNum && p<q){
            if (sumHelper(arr,p,q) < target){
                q++;
            }else if (sumHelper(arr,p,q)>target){
                p++;
            }else {
//                System.out.println(arr[p]);
//                System.out.println(arr[q]);
                int[] result = new int[q-p+1];

                for (int i=0,j=p;i<=q-p;i++,j++){
                    result[i] = arr[j];
                }
                //System.out.println(Arrays.toString(result));
                vec.add(result);
                p++;
                q++;
            }
        }
        return vec.toArray(new int[vec.size()][]);

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int target = 15;

        int[][] result = s.findContinuousSequence2(target);
    }
}