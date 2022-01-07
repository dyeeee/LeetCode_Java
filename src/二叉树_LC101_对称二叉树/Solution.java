package 二叉树_LC101_对称二叉树;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
        {
            return true;
        }
        else{
            return recur(root.left, root.right);
        }
        // return root == null ? true : recur(root.left, root.right);
    }

    public boolean recur(TreeNode l, TreeNode r)
    {
        if(l == null && r==null)
        {
            return true;
        }
        // 只存在一个子节点 或者左右不相等
        if(l==null || r==null || l.val != r.val)
        {
            return false;
        }

        return recur(l.left, r.right) && recur(l.right, r.left);
    }



}