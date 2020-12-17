package com.yanhuan.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 *
 * @author YanHuan
 * @date 2020-12-17 20:59
 */
public class LeetCode105 {

    /**
     * 解法1
     *
     * @param preorder 前序遍历序列
     * @param inorder  中序遍历序列
     * @return 树
     */
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }


    /**
     * 构造二叉树，返回该二叉树的根节点
     *
     * @param preorder 前序数组
     * @param preStart 前序数组开始索引
     * @param preEnd   前序数组结束索引
     * @param inorder  中序数组
     * @param inStart  中序数组开始索引
     * @param inEnd    中序数组结束索引
     * @return 二叉树
     */
    TreeNode build(int[] preorder, int preStart, int preEnd,
                   int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];
        // rootVal 在中序遍历数组中的索引
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        //左子树的节点数为leftSize
        int leftSize = index - inStart;

        //构造当前根节点
        TreeNode root = new TreeNode(rootVal);
        // 递归构造左右子树
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);

        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);
        return root;
    }


    /**
     * 解法2（官方答案）
     *
     * @param preorder 前序遍历序列
     * @param inorder  中序遍历序列
     * @return 树
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        if (preorder.length != inorder.length) {
            return null;
        }
        //将中序遍历缓存在map中
        Map<Integer, Integer> map = new HashMap<>(inLen);
        for (int i = 0; i < inLen; i++) {
            map.put(inorder[i], i);
        }
        return buildTree2(preorder, 0, preLen - 1, map, 0, inLen - 1);
    }

    /**
     * 递归构建树
     *
     * @param preorder 前序遍历序列
     * @param preLeft  前序遍历序列子区间的左边界
     * @param preRight 前序遍历序列子区间的右边界
     * @param map      中序遍历序列数值与索引的对应关系
     * @param inLeft   中序遍历序列子区间的左边界，可以取到
     * @param inRight  中序遍历序列子区间的右边界，可以取到
     * @return 二叉树
     */
    private TreeNode buildTree2(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> map, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }

        //根节点
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int pIndex = map.get(rootVal);

        root.left = buildTree2(preorder, preLeft + 1, pIndex - inLeft + preLeft, map, inLeft, pIndex - 1);
        root.right = buildTree2(preorder, pIndex - inLeft + preLeft + 1, preRight, map, pIndex + 1, inRight);
        return root;
    }
}
