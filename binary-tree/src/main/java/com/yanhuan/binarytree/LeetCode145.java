package com.yanhuan.binarytree;

import com.yanhuan.TreeNode;

import java.util.*;

/**
 * 二叉树的后序遍历
 *
 * @author YanHuan
 * @date 2021-01-05 22:24
 */
public class LeetCode145 {
    /**
     * 解法1：递归
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     * @param root 二叉树
     * @return 遍历结果
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        postorder(root, list);
        return list;
    }

    private void postorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }

    /**
     * 解法2：迭代
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     * @param root 二叉树
     * @return 遍历结果
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                list.add(root.val);
                //根节点放入栈
                stack.push(root);
                //遍历右子树
                root = root.right;
            }
            root = stack.pop();
            //遍历左子树
            root = root.left;
        }
        Collections.reverse(list);
        return list;
    }
}
