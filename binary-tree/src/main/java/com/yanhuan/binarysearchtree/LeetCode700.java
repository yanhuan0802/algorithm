package com.yanhuan.binarysearchtree;

import com.yanhuan.TreeNode;

/**
 * 二叉搜索树中的搜索
 *
 * @author YanHuan
 * @date 2020-12-21 21:37
 */
public class LeetCode700 {

    /**
     * 解法1:递归
     * <p>
     * 时间复杂度：O(H)，H为树的高度。平均时间复杂度为O(logN)，最坏时间复杂度为O(N)
     *
     * @param root 二叉搜索树
     * @param val  值
     * @return 搜索结果
     */
    public TreeNode searchBST1(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        return root.val < val ? searchBST1(root.right, val) : searchBST1(root.left, val);
    }

    /**
     * 解法2:迭代
     * 时间复杂度：O(H)，H为树的高度。
     *
     * @param root 二叉搜索树
     * @param val  值
     * @return 搜索结果
     */
    public TreeNode searchBST2(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }
}
