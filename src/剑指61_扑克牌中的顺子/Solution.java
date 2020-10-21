package 剑指61_扑克牌中的顺子;

//从扑克牌中随机抽5张牌，判断是不是一个顺子，
// 即这5张牌是不是连续的。2～10为数字本身，
// A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。
// A 不能视为 14。
//
//        示例 1:
//        输入: [1,2,3,4,5]
//        输出: True
//         
//
//        示例 2:
//        输入: [0,0,1,2,5]
//        输出: True


import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    // 主要思路：
    // //用JOKER可以替代任何元素作为计数（容错情况）
    // 判断差和判断是否重复可以一起做，不用单独用hashSet做
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        while(nums[count] == 0) count++;   //count为0出现的次数
        int i = count+1;            //i是左边第二个不为0的元素

        for(int j = i; j<5;j++) {
            int dif = nums[j] - nums[j-1] ;    //dif为相邻两元素的差值，
            count = count - dif +1;     //count= count-(dif-1)，用count来修补数组中不符合要求的元素
            if(count<0 || dif == 0) return false;   //count为0表示已经用完大小王修补错误，dif=0表示存在相同元素
        }

        return true;
    }

    // 这个思路数组中有重复的数字就不行
    // 添加了hashSet来处理但是还是比较混乱
    public boolean isStraight2(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer> haset = new HashSet<>();
        HashSet<Integer> nozero = new HashSet<>();

        for (int num:nums){
            haset.add(num);
            //System.out.println(num);
            if (num!=0){
                nozero.add(num);
                //System.out.println(num);
            }
        }

        if (haset.contains(0) && haset.size() - nozero.size() != 1){
            return false;
        }else if (!haset.contains(0) && haset.size() != 5){
            return false;
        }

        if (nums[0] != 0) {
            return (nums[4] - nums[0] == 4);
        } else if (nums[0] == 0 && nums[1] != 0) {
            return (nums[4] - nums[1] == 4 || nums[4] - nums[1] == 3);
        } else {
            return (nums[4] - nums[2] == 4 || nums[4] - nums[2] == 3 || nums[4] - nums[2] == 2);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 3, 4, 5};
        int[] nums2 = {0, 0, 2, 2,6};

        boolean result = s.isStraight2(nums2);

        System.out.println(result);
    }
}
