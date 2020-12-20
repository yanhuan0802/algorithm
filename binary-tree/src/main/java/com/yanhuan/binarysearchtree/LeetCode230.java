package com.yanhuan.binarysearchtree;

import com.yanhuan.TreeNode;

import java.util.LinkedList;

/**
 * 二叉搜索树中第K小的元素
 *
 * @author YanHuan
 * @date 2020-12-20 14:26
 */
public class LeetCode230 {
    /**
     * 元素值
     */
    int res = 0;
    /**
     * 元素排名
     */
    int rank = 0;

    /**
     * 解法1：递归
     *
     * @param root 根
     * @param k    查询条件
     * @return 结果
     */
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    /**
     * 解法1：递归
     *
     * @param root 树
     * @param k    查询条件
     */
    private void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);
        //中序遍历
        rank++;
        if (k == rank) {
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }

    /**
     * 解法2：迭代（官方答案）
     *
     * @param root 根
     * @param k    查询条件
     * @return 结果
     */
    public int kthSmallest2(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
    }
}
