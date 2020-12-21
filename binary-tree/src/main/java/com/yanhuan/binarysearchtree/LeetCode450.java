package com.yanhuan.binarysearchtree;

import com.yanhuan.TreeNode;

/**
 * 删除二叉搜索树中的节点
 *
 * @author YanHuan
 * @date 2020-12-21 22:23
 */
public class LeetCode450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            //替换右子树最小节点(后继节点：比当前节点大的最小节点)为当前节点
            //也可以替换左子树最大节点(前驱节点：比当前节点小的最大节点)为当前节点
            //这两个点都可以保证左子树比它小，右子树比它大，所以取一个就可以
//            TreeNode minNode = getMin(root.right);
//            root.val = minNode.val;
//            root.right = deleteNode(root.right, minNode.val);
            TreeNode maxNode = getMax(root.left);
            root.val = maxNode.val;
            root.left = deleteNode(root.left, maxNode.val);
        } else if (root.val > key) {
            //去左子树找
            root.left = deleteNode(root.left, key);
        } else {
            //去右子树找
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    /**
     * 获取最大节点
     *
     * @param node 二叉搜索树
     * @return 最大节点
     */
    private TreeNode getMax(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    /**
     * 获取最小节点
     *
     * @param node 二叉搜索树
     * @return 最小节点
     */
    private TreeNode getMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
