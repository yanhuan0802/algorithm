package com.yanhuan.binarysearchtree;

import com.yanhuan.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 恢复二叉搜索树
 *
 * @author YanHuan
 * @date 2020-12-22 21:03
 */
public class LeetCode99 {

    /**
     * 解法1：显示中序遍历
     * 时间复杂度：O(N)O(N)，其中 NN 为二叉搜索树的节点数。中序遍历需要 O(N)O(N) 的时间，判断两个交换节点在最好的情况下是 O(1)O(1)，在最坏的情况下是 O(N)O(N)，因此总时间复杂度为 O(N)O(N)。
     * 空间复杂度：O(N)O(N)。我们需要用 \textit{nums}nums 数组存储树的中序遍历列表。
     *
     * @param root 树
     */
    public void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        //中序遍历
        inorder(root, nums);
        //如果不是标准的二叉树，数组中肯定有两个下降点，将这两个下降点找出来
        int[] swapped = findTwoSwapped(nums);
        //交换这两个下降点的位置
        recoverTree(root, 2, swapped[0], swapped[1]);
    }

    /**
     * 交换两个下降点的位置
     *
     * @param root  树
     * @param count 下降点数目
     * @param x     下降点值
     * @param y     下降点值
     */
    private void recoverTree(TreeNode root, int count, int x, int y) {
        if (root == null) {
            return;
        }
        //找出值为x或者y的节点
        if (root.val == x || root.val == y) {
            root.val = root.val == x ? y : x;
            if (--count == 0) {
                return;
            }
        }
        //递归匹配左子树和右子树
        recoverTree(root.left, count, x, y);
        recoverTree(root.right, count, x, y);
    }

    /**
     * 查找下降点
     *
     * @param nums 值集合
     * @return 下降点
     */
    private int[] findTwoSwapped(List<Integer> nums) {
        //初始化xy  用于存这两个下降点的索引
        int x = -1, y = -1;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i + 1) < nums.get(i)) {
                //Y是找出的第二个下降点
                y = nums.get(i + 1);
                if (x == -1) {
                    //升序的话  x是找出的第一个下降点
                    x = nums.get(i);
                } else {
                    break;
                }
            }
        }
        return new int[]{x, y};
    }

    /**
     * 中序遍历
     *
     * @param root 树
     * @param list 值集合
     */
    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        //左子树
        inorder(root.left, list);
        //获取值
        list.add(root.val);
        //右子树
        inorder(root.right, list);
    }

    public void recoverTree2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode x = null, y = null, pred = null;
        //查找
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pred != null && root.val < pred.val) {
                y = root;
                if (x == null) {
                    x = pred;
                } else {
                    break;
                }
            }
            pred = root;
            root = root.right;
        }
        //交换
        swap(x, y);
    }

    /**
     * 交换节点值
     *
     * @param x x节点
     * @param y y节点
     */
    private void swap(TreeNode x, TreeNode y) {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }
}
