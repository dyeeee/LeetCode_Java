package 滑动窗口_3_无重复字符的最长子串;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0){
            return 0;
        }
        String[] list = s.split("");
        int l = 0;
        int r = 0;
        int n = list.length;
        int result = 1;

        while(r<n){

            String inside = s.substring(l,r+1);
            System.out.println(inside);
            r += 1;
            if (r<n && inside.contains(list[r])){
                l += 1;
                l = r;
//                if (list[l].equals(list[r])){
//                    r = l;
//                }
            }
            result = Math.max(inside.length(),result);
        }




        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "dvdf";

        int result = s.lengthOfLongestSubstring(str);
        System.out.println(result);
    }
}