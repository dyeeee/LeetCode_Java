package 剑指27_二叉树的镜像_二叉树;


 // Definition for a binary tree node.
class TreeNode {
     int val;
 TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        // 看起来更牛的递归
        // if(root == null) return null;
        // TreeNode tmp = root.left;
        // root.left = mirrorTree(root.right);
        // root.right = mirrorTree(tmp);
        // return root;

        //标准递归
        if(root == null) {return root;}
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;

        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;

        // 超时 本身就递归了 还加了while，理解有问题
        // while(root != null){
        //     TreeNode tmp = root.right;
        //     root.right = root.left;
        //     root.left = tmp;

        //     mirrorTree(root.left);
        //     mirrorTree(root.right);
        // }
        // return root;
    }
}