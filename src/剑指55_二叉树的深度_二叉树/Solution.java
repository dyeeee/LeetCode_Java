package 剑指55_二叉树的深度_二叉树;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 求左高度和右高度
        int leftheight = maxDepth(root.left);
        int rightheight = maxDepth(root.right);
        return Math.max(leftheight, rightheight) + 1;
    }

    //简洁写法
    //核心是一颗二叉树的深度等左右子数中深度较大+1
    //叶子的左右都为0，叶子为1逐层往上递归
    private int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }


}
