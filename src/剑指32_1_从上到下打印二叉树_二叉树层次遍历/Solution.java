package 剑指32_1_从上到下打印二叉树_二叉树层次遍历;

import java.util.ArrayList;
import java.util.LinkedList;
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

    // LC题解
    // 非递归
    public int[] levelOrder2(TreeNode root) {
        // 根节点为空则直接返回
        if (root == null) return new int[0];

        //根节点作为队首元素
        Queue<TreeNode> queue = new LinkedList<>() {{
            add(root);
        }};
        //遍历结果
        ArrayList<Integer> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            //当前队首节点出队并加入结果
            TreeNode node = queue.poll();
            ans.add(node.val);

            // 二叉树，只用考虑队首节点的左右直接入队
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }


//	//回忆外教思路：BFS顺序为入队顺序
//            a. 白色节点入队，从队头开始找可达的白色节点；
//            b. 入队后变为灰色；
//            c. 无可达节点则出队，变黑色；
//            d. 继续从队头开始找可达的白色节点

    // 这样写超时了
    public int[] levelOrder(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();

        if (root == null) {
            return null;
        } else {
            nodeQueue.offer(root);
            result.add(root.val);
        }

        while (!nodeQueue.isEmpty()) {
            if (nodeQueue.peek().left != null) {
                nodeQueue.offer(nodeQueue.peek().left);
                result.add(nodeQueue.peek().left.val);
            }
            if (nodeQueue.peek().right != null) {
                nodeQueue.offer(nodeQueue.peek().right);
                result.add(nodeQueue.peek().right.val);
            }
            if (nodeQueue.peek().left == null && nodeQueue.peek().right == null) {
                nodeQueue.poll();
            }

        }

        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++)
            res[i] = result.get(i);
        return res;
    }
}