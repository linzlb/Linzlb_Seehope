package com.linzlb.juan.leetcode;

import com.linzlb.juan.labuladong.entry.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 找树左下角的值
 * 难度 中等
 *
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 假设二叉树中至少有一个节点。
 *
 * @author jiangwan.lin@tuya.com
 * @since 2022-06-22 10:21 上午 / V1.0
 */
public class Solution513 {

    // 深度搜索
    //使用 \textit{height}height 记录遍历到的节点的高度，
    // \textit{curVal}curVal 记录高度在 \textit{curHeight}curHeight 的最左节点的值。
    //在深度优先搜索时，我们先搜索当前节点的左子节点，
    // 再搜索当前节点的右子节点，然后判断当前节点的高度 \textit{height}height 是否大于 \textit{curHeight}curHeight，
    // 如果是，那么将 \textit{curVal}curVal 设置为当前结点的值，\textit{curHeight}curHeight 设置为 \textit{height}height。
    int curVal = 0;
    int curHeight = 0;

    public int findBottomLeftValue(TreeNode root) {
        int curHeight = 0;
        dfs(root, 0);
        return curVal;
    }

    public void dfs(TreeNode root, int height) {
        if (root == null) {
            return;
        }
        height++;
        dfs(root.left, height);
        dfs(root.right, height);
        if (height > curHeight) {
            curHeight = height;
            curVal = root.val;
        }
    }




    //广度优先
    //使用广度优先搜索遍历每一层的节点。
    // 在遍历一个节点时，需要先把它的非空右子节点放入队列，然后再把它的非空左子节点放入队列，
    // 这样才能保证从右到左遍历每一层的节点。广度优先搜索所遍历的最后一个节点的值就是最底层最左边节点的值。
    public int findBottomLeftValue2(TreeNode root) {
        int ret = 0;
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            if (p.right != null) {
                queue.offer(p.right);
            }
            if (p.left != null) {
                queue.offer(p.left);
            }
            ret = p.val;
        }
        return ret;
    }



}
