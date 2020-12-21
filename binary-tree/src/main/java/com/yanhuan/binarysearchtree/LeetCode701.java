package com.yanhuan.binarysearchtree;

import com.yanhuan.TreeNode;

/**
 * 二叉搜索树中的插入操作
 *
 * @author YanHuan
 * @date 2020-12-21 21:58
 */
public class LeetCode701 {

    /**
     * 解法1：递归
     * 小于当前节点值就递归调用当前函数插入到左子树，大于当前节点值就递归调用当前函数插入到右子树
     *
     * @param root 二叉搜索树
     * @param val  插入值
     * @return 插入结果
     */
    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        //将值插入到左子树
        if (root.val > val) {
            root.left = insertIntoBST1(root.left, val);
        }
        //将值插入到右子树
        if (root.val < val) {
            root.right = insertIntoBST1(root.right, val);
        }
        return root;
    }

    /**
     * 解法2：迭代
     * 比大小  找到空节点  将当前值插入进去
     *
     * @param root 二叉搜索树
     * @param val  插入值
     * @return 插入结果
     */
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null) {
            return node;
        }
        TreeNode cur = root;
        while (true) {
            if (cur.val > val) {
                if (cur.left == null) {
                    cur.left = node;
                    break;
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = node;
                    break;
                }
                cur = cur.right;
            }
        }
        return root;
    }
}
