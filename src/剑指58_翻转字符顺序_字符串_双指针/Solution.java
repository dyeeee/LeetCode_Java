package 剑指58_翻转字符顺序_字符串_双指针;

public class Solution {

    // 双指针思路，从尾到头两个指针找出所有单词，跳过空格
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder result = new StringBuilder();
        int right = s.length() -1,left=right;

        while(left>=0){
            //从右往左移动直到找到第一个空格的位置
            while(left >= 0 && s.charAt(left) != ' ') left--;

            //substring左闭右开
            result.append(s.substring(left+1,right+1)+' ');

            //跳过可能的多个连续空格
            while(left >= 0 && s.charAt(left) == ' ') left--;

            right = left;

        }

        //StringBUilder 转为String
        return result.toString().trim();

    }



    public static void main(String[] args) {
        String a = "hello";
        String b = "hello";

        String a1 = new String("hello");
        String a2 = new String("hello");

        StringBuilder c = new StringBuilder("hello");
        StringBuilder d = new StringBuilder("hello");

        //System.out.println(a1.equals(a2));
        System.out.println(new Solution().reverseWords(" hello world!"));
    }
}
