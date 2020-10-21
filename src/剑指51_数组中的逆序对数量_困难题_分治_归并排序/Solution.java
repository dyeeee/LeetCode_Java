package 剑指51_数组中的逆序对数量_困难题_分治_归并排序;

//在数组中的两个数字，如果前面一个数字大于后面的数字，
//则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
//输入: [7,5,6,4]
//输出: 5

import java.util.Arrays;

class Solution {

    // 暴力双循环超时；
    public int reversePairs2(int[] nums) {
        int result = 0;
        for(int i =0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] > nums[j]){
                    result ++;
                }
            }
        }

        return result;
    }


    public int reversePairs(int[] nums) {
        return merge(nums, 0, nums.length - 1);
    }

    int merge(int[] arr, int start, int end) {
        if (start == end) return 0;
        int mid = (start + end) / 2;
        int count = merge(arr, start, mid) + merge(arr, mid + 1, end);

        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            count += arr[i] <= arr[j] ? j - (mid + 1) : 0;
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            count += j - (mid + 1);
            temp[k++] = arr[i++];
        }
        while (j <= end)
            temp[k++] = arr[j++];
        System.arraycopy(temp, 0, arr, start, end - start + 1);
        return count;
    }


    //结合归并排序与计数
    //不用三元操作符都超时，无法通过
    static int mergeSort(int[] arr, int start, int end) {

        if (start >= end) return 0; //只剩一个元素时直接返回

        //划分区域
        int mid = start + (end - start) / 2;
        System.out.println("start:"+start+",mid:"+mid+",end:"+end);

        //计数
        int count = mergeSort(arr, start, mid) + mergeSort(arr, mid + 1, end);


        //左右各自递归，传入索引
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        //开始合并
        //暂存这一次数组，用于合并结果
        int[] temp = new int[end - start + 1];

        //ij分别指向两个已经排好序的子数组开始
        int i = start, j = mid + 1, tmpIndex = 0;
        while(i <= mid && j <= end){
            if(arr[i] <= arr[j]){
                //System.out.println(arr[i]);
                temp[tmpIndex] = arr[i];
                i++;
                //count j及其之后的所有元素都可以与i组成逆序对????
                count += j - (mid + 1);
            }else{
                temp[tmpIndex]  = arr[j];
                j++;
            }
            tmpIndex++;
            //System.out.println(count);
        }

        //继续做合并操作
        while(i <= mid) {
            temp[tmpIndex] = arr[i];
            tmpIndex++;
            i++;
            //count
            count += j - (mid + 1);
        }
        while(j <= end) {
            temp[tmpIndex] = arr[j];
            tmpIndex++;
            j++;
        }

        //将arr的部分区域用排好序的temp替换
        System.arraycopy(temp, 0, arr, start,  end-start+1);
        //temp从0开始替换到arr的start位置开始，end-start+1长度

        //System.out.println(count);
        return count;
    }



    public static void main(String[] args) {
        int[] nums = {7,5,6,4};
        //System.out.println(new Solution().reversePairs(nums));

        Solution.mergeSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}