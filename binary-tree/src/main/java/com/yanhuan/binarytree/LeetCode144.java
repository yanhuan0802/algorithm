package com.yanhuan.binarytree;

import com.yanhuan.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的前序遍历
 *
 * @author YanHuan
 * @date 2021-01-05 21:58
 */
public class LeetCode144 {
    /**
     * 解法1：递归
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     * @param root 树
     * @return 遍历结果
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        preorder(root, list);
        return list;
    }

    private void preorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    /**
     * 解法2：迭代
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     * @param root 树
     * @return 遍历结果
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                //遍历左子树
                root = root.left;
            }
            root = stack.pop();
            //遍历右子树
            root = root.right;
        }
        return list;
    }
}
