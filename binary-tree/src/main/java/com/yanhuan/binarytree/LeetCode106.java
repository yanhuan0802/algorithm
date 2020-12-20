package com.yanhuan.binarytree;

import com.yanhuan.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从中序遍历与后序遍历序列构造二叉树
 *
 * @author YanHuan
 * @date 2020-12-20 10:54
 */
public class LeetCode106 {

    /**
     * 解法1
     *
     * @param inorder   中序遍历数组
     * @param postorder 后序遍历数组
     * @return 二叉树
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen = inorder.length;
        int postLen = postorder.length;
        if (inLen != postLen) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>(inLen);
        for (int i = 0; i < inLen; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(map, 0, inLen - 1, postorder, 0, postLen - 1);
    }

    private TreeNode buildTree(Map<Integer, Integer> map, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }
        //根节点
        int rootVal = postorder[postRight];
        TreeNode root = new TreeNode(rootVal);
        int index = map.get(rootVal);
        root.left = buildTree(map, inLeft, index - 1, postorder, postLeft, index - inLeft + postLeft - 1);
        root.right = buildTree(map, index + 1, inRight, postorder, index - inLeft + postLeft, postRight - 1);
        return root;
    }
}
