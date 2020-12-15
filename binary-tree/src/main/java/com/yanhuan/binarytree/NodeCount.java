package com.yanhuan.binarytree;

/**
 * 计算一棵二叉树上面有几个节点
 *
 * @author YanHuan
 * @date 2020-12-15 23:06
 */
public class NodeCount {
    /**
     * 计算一棵二叉树上面有几个节点
     *
     * @param root 二叉树
     * @return 节点数
     */
    int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //自己加上子树的节点数
        return 1 + count(root.left) + count(root.right);
    }
}
