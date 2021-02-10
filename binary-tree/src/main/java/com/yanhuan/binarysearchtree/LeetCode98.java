package com.yanhuan.binarysearchtree;

import com.yanhuan.TreeNode;

/**
 * 判断BST合法性
 *
 * @author YanHuan
 * @date 2020-12-20 16:09
 */
public class LeetCode98 {

    boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /**
     * 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root 树
     * @param min  子树节点
     * @param max  子树节点
     * @return 校验结果
     */
    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
}
