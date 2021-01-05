package com.yanhuan.binarytree;

import com.yanhuan.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的中序遍历
 *
 * @author YanHuan
 * @date 2021-01-05 21:05
 */
public class LeetCode94 {
    /**
     * 解法1 递归
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     * @param root 树
     * @return 遍历结果
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    /**
     * 解法2 栈
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     * @param root 树
     * @return 遍历结果
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            //压栈
            while (root != null) {
                stack.push(root);
                //遍历左子树
                root = root.left;
            }
            //弹栈
            root = stack.pop();
            list.add(root.val);
            //换到当前节点右子树
            //遍历右子树
            root = root.right;
        }
        return list;
    }
}
