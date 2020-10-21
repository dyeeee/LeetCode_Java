package 剑指55_2_判断二叉树是否平衡;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


// 平衡：每一个节点的左子树和右子树高度差小于1
// 平衡不一定对称
class Solution {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        //方法拆解，深度的只负责深度（递归），平衡的只负责平衡（递归）
        //会重复计算很多节点的高度，因为平衡从顶向下判断，每次判断都从底向上求高度
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    // 求树的深度，和55题一样
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 求左高度和右高度
        int leftheight = maxDepth(root.left);
        int rightheight = maxDepth(root.right);
        return Math.max(leftheight, rightheight) + 1;
    }

    // 求树的深度
    // 核心是一颗二叉树的深度等左右子数中深度较大+1
    // 叶子的左右都为0，叶子为1逐层往上递归
    int depth(TreeNode root){
        if (root == null) {return 0;}
        return Math.max(depth(root.left),depth(root.right)) + 1;
    }

}