package com.yanhuan.binarysearchtree;

import com.yanhuan.TreeNode;

/**
 * 把二叉搜索树转化为累加树
 * <p>
 * LeetCode538和LeetCode1038  相同题目
 *
 * @author YanHuan
 * @date 2020-12-20 15:30
 */
public class LeetCode538 {
    /**
     * 记录累加和
     */
    int sum = 0;

    /**
     * 解法1：反序中序遍历
     *
     * @param root 原树
     * @return 累加树
     */
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        //中序遍历反过来  降序得到值
        convertBST(root.right);
        //维护累加和
        sum += root.val;
        //转化为累加树
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
