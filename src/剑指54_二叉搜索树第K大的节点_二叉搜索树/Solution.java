package 剑指54_二叉搜索树第K大的节点_二叉搜索树;

import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// 普通的正向递归求出取第len-k个数思路
// 注意ArrayList是怎么取数的 get方法
// 注意类里的全局变量怎么用 this.k
class Solution {
    int result , k;
    //遍历结果
    ArrayList<Integer> ans = new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ans.get(ans.size()-k);
    }

    // 中序遍历，把结果存在全局ArrayList里
    void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        ans.add(root.val);
        dfs(root.right);
    }


    //题解方法
    //中序倒序，并且只需要k次（正序的话不知道size()，没办法直接取数，需要存储结果）
    int result2 , k2;
    public int kthLargest2(TreeNode root, int k) {
        this.k2 = k;
        dfs(root);
        return result2;
    }
    void dfs2(TreeNode root) {
        if(root == null) return;
        dfs(root.right);
        if(k2 == 0) return;
        // 关键步骤，遍历从第1大的开始，k也跟着减，k=1的时候遍历到第k大的
        // --k==0意味着找到了第k大的
        if(--k2 == 0) result2 = root.val;
        dfs(root.left);
    }



}