package 剑指32_2_从上到下打印二叉树_二叉树层次遍历;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    // LC
    // 和32-1 不同在于，每层要分别输出
    // 难点在于如何看每层的长度
    // 这个是非递归解法；用DFS+记录层数的递归写法到时补充一下
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        if(root != null) queue.add(root);


        while(!queue.isEmpty()) {
            // 注意
            List<Integer> tmp = new ArrayList<>();

            //题解思路非常巧妙
            //利用队列当前的长度作为当前层的循环次数
            //比如添加第二层的两个节点，即把这两个节点放入结果中输出，又把这两个节点的左右添加进来，下一层就有四个节点
            //不一定是满二叉树，所以不是固定1-2-4-8，要动态判断长度
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
