package 剑指15_二进制中1的个数_位运算;
// 标签：位运算
// 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
// 例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。


// 把一个整数减去1，再和原来的数做与运算，就会把该整数最右边的1变成0
// n&(n-1)直到所有1都变成0看变了多少次
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int num = 9;

        int result = s.hammingWeight(num);
        System.out.println(result);


        System.out.println(2^2);
    }
}