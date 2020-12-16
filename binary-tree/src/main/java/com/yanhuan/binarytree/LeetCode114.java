package com.yanhuan.binarytree;

import java.util.Stack;

/**
 * 二叉树展开为链表
 *
 * @author YanHuan
 * @date 2020-12-16 21:30
 */
public class LeetCode114 {

    /**
     * 解法1
     *
     * @param root 树
     */
    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        //1.将左右子树先拉平
        flatten1(root.left);
        flatten1(root.right);

        //后序遍历
        TreeNode left = root.left;
        TreeNode right = root.right;

        //2.将左子树作为右子树
        root.left = null;
        root.right = left;

        //3.将原来的右子树接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

    /**
     * 解法2
     *
     * @param root 树
     */
    public void flatten2(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                //找到左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将原来的右子树拼接到左子树最右边
                pre.right = root.right;

                //将左子树插入到右子树的地方
                root.right = root.left;
            }
            //考虑下一个节点
            root = root.right;
        }
    }

    /**
     * TODO 解法3
     *
     * @param root 树
     */
    public void flatten3(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            root = root.right;
        }
    }
}
