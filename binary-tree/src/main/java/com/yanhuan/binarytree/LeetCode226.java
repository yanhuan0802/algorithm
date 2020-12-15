package com.yanhuan.binarytree;

/**
 * leetCode226题  翻转二叉树
 *
 * @author YanHuan
 * @date 2020-12-15 23:21
 */
public class LeetCode226 {

    /**
     * 翻转二叉树
     *
     * 只要把二叉树上的每一个节点的左右子节点进行交换，最后的结果就是完全翻转之后的二叉树。
     *
     * 前序遍历和后序遍历都可以，中序遍历不行
     *
     * @param root 翻转前
     * @return 翻转后
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //前序遍历
        //翻转
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        //子节点翻转
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
