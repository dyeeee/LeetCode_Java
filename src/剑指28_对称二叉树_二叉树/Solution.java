package 剑指28_对称二叉树_二叉树;


// 如果一个二叉树和他的镜像是一样的，那就是对称的
// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }else {
            return recur(root.left, root.right);
        }
    }

    boolean recur(TreeNode L, TreeNode R) {
        //同时指向空则返回true
        if(L == null && R == null) return true;
        //有一边指向空了而另一边没有或者值不相等则false
        if(L == null || R == null || L.val != R.val) return false;

        // 两边递归，需要同时满足
        // 左节点的左和右节点的右判断；
        // 左节点的右和右节点的左判断；
        return recur(L.left, R.right) && recur(L.right, R.left);
    }
}
