package 剑指29_顺时针打印矩阵;


import java.util.Arrays;

//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
//输入：matrix = [[1,2,3]
//              ,[4,5,6]
//              ,[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]

//输入：matrix = [[1,2,3,4]
//              ,[5,6,7,8]
//              ,[9,10,11,12]]
//        输出：[1,2,3,4,8,12,11,10,9,5,6,7]
public class Solution {

    //基本思路和自己想的也差不多
    // 四个边界的移动要理清楚
    // 固定某一边界，移动，收缩边界
    // 从左走到右就固定上方的行（top），从上走到下就固定r，以此类推
    // 结束条件为top > bottom / left  > right
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];

        //左右上下四个边界
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;

        //总长度
        int[] res = new int[(r + 1) * (b + 1)];

        while(true) {
            for(int i = l; i <= r; i++) {
                //固定top，从左到右
                res[x] = matrix[t][i];
                x++;
            } // left to right.
            t++; //top++，即下一个top在第二行
            if( t > b) break;

            for(int i = t; i <= b; i++) {
                //固定r，从top到bottom
                res[x] = matrix[i][r];
                x++;
            } // top to bottom.
            r--; //r--，下一个r在倒数第二列
            if(l > r) break;

            for(int i = r; i >= l; i--) {
                //固定bottom，从右到左
                res[x] = matrix[b][i];
                x++;
            } // right to left.
            b--; //b--，下一个b在倒数第二行
            if(t > b) break;

            for(int i = b; i >= t; i--) {
                //固定left，从b到t
                x++;
                res[x] = matrix[i][l];
            } // bottom to top.
            l++; //l++，从第二列开始
            if(l > r) break;
        }
        return res;
    }


    /// 自己写的边界条件一直差一点
    // 思路：双指针，行指针和列指针左右移动定位元素
    public int[] spiralOrder_fail(int[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0) return new int[0];
        else if(matrix.length==1 && matrix[0].length==1) return new int[]{matrix[0][0]};

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] result = new int[rows * cols];
        int totalCount = 0;
        int totalLength = rows * cols;
        int p = 0, q = 0;
        int left = 0,top = 0;


        while (totalCount < totalLength && rows>0) {
            // 向右循环
            System.out.println("向右");
            for (int i = 0; i < cols - 1; i++) {
                result[totalCount] = matrix[p][q];
                totalCount++;
                if (totalCount == totalLength) return result;
                q++;
            }
            System.out.println(Arrays.toString(result));
            //System.out.println(q);

            //向下循环
            System.out.println("向下");
            for (int i = 0; i < rows - 1; i++) {
                result[totalCount] = matrix[p][q];
                totalCount++;
                if (totalCount == totalLength) return result;
                p++;
            }
            System.out.println(Arrays.toString(result));

            //向左循环
            System.out.println("向左");
            for (int i = q; i > left; i--) {
                result[totalCount] = matrix[p][q];
                totalCount++;
                if (totalCount == totalLength) return result;
                q--;
            }
            System.out.println(Arrays.toString(result));

            //向上循环
            System.out.println("向上");
            for (int i = p; i > top; i--) {
                result[totalCount] = matrix[p][q];
                totalCount++;
                if (totalCount == totalLength) return result;
                p--;
            }


            System.out.println(Arrays.toString(result));
            System.out.println("ddd");
            rows -= 2;
            cols -= 2;
            p++;
            q++;
            left++;
            top++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4, 5}
                         ,{6, 7, 8, 9, 10}
                         ,{11,12,13,14,15}
                         ,{16,17,18,19,20}
                         ,{21,22,23,24,25}};
        int[][] sp = {{1,2,3},{4,5,6},{7,8,9}};

        int[] result = new Solution().spiralOrder_fail(sp);

        System.out.println("result: " + Arrays.toString(result));
    }
}
