package 剑指56_2_数组中不重复的数字_位运算;

import java.util.ArrayList;
import java.util.Arrays;

//数组中一个数字不重复，别的数字重复三次
class Solution {

    //如果一个数字出现三次,那么它的二进制表示的每一位(0或者1)也出现三次。
    // 如果把所有出现三次的数字的二进制表示的每一位都分别加起来,那么每一位的和都能被3整除。
    // 如果某一位的和能被3整除,那么那个只出现一次的数字二进制表示中对应的那一位是0;否则就是1;

    //java int32位，用一个32位的数组存储每一位的结果
    public int singleNumbers(int[] nums) {
        if (nums.length==0) return -1;
        int[] bitCount = new int[32];

        for (int num:nums){
            int bitMask = 1;
            for (int i=31;i>=0;i--){
                if ((num & bitMask) != 0){
                    bitCount[i] ++;

                }
                bitMask = bitMask<<1;
            }
        }

        int res=0;


        //System.out.println(Arrays.toString(bitCount));
        //把32位对3取余
        for (int i=31,j=0;i>=1;i--,j++){
            res+= bitCount[i]%3*Math.pow(2,j);
        }
        //这样的话负数就要单独判断
        if (bitCount[0] == 1){
            return -res;
        }else{
            return res;
        }

        // 左移的本质就是*2，java中左移不改变符号位，
        // 一边左移一边加对应位置的1，然后左移
//        for(int i=0;i<32;i++){ //这种做法使得本算法同样适用于负数的情况
//            res=res<<1;
//            res+=bitCount[i]%3; //这两步顺序不能变，否则最后一步会多左移一次
//        }

    }

    public static void main(String[] args) {
        int[] nums = {3,3,3,5};

        int result = new Solution().singleNumbers(nums);
        System.out.println(result);

        System.out.println(-1);
        System.out.println(-1<<1);
    }
}