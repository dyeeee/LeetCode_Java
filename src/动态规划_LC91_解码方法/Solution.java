package 动态规划_LC91_解码方法;

import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public int numDecodings_fail(String s) {
        String[] list = s.split("");

        if (list.length == 1 && !list[0].equals("0")){
            return 1;
        }
        else if (list[0].equals("0")){
            return 0;
        }


        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, 0);
        dp[0] = 0;
        dp[1] = 1;
        if (!list[1].equals("0") && Integer.parseInt(list[1]) < 7){
            dp[2] = 2;
        }else
        {
            dp[2] = 1;
        }

        for (int i = 3; i <= list.length; i++) {
            String tmp = list[i-2].concat(list[i-1]);
            int tmp_int = Integer.parseInt(tmp);
            System.out.println("转换结果");
            System.out.println(tmp_int);

            if (tmp_int <= 26 && Integer.parseInt(list[i-2])!=0 && Integer.parseInt(list[i-1])!=0){
                dp[i] = dp[i-1] + 1;
            } else if (tmp_int > 26 || Integer.parseInt(list[i-2])==0) {
                dp[i] = dp[i - 1];
            }else {
                dp[i] = dp[i - 2];
            }
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i]);
            System.out.print(" ");
            System.out.println("");
        }


        return dp[s.length()];
    }

    public int numDecodings(String s) {
        String[] list = s.split("");

        if (list.length == 1 && !list[0].equals("0")){
            return 1;
        }
        else if (list[0].equals("0")){
            return 0;
        }


        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;



        for (int i = 1; i <= list.length; i++) {


            if (Integer.parseInt(list[i-1])!=0){
                dp[i] += dp[i-1];
                // 能单个组成新的字母
            }
            if(i>1) {
                String tmp = list[i-2].concat(list[i-1]);
                int tmp_int = Integer.parseInt(tmp);
                System.out.println("转换结果");
                System.out.println(tmp_int);

                if (tmp_int <= 26 && Integer.parseInt(list[i - 2]) != 0) {
                    // 能和上一个组成新的字母
                    dp[i] += dp[i - 2];
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i]);
            System.out.print(" ");
            System.out.println("");
        }


        return dp[s.length()];
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "301";

        int result = s.numDecodings(str);
        System.out.println("result");
        System.out.println(result);
    }
}