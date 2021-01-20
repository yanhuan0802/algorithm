package com.yanhuan.binarytree;

import com.yanhuan.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的层序遍历
 *
 * @author YanHuan
 * @date 2021-01-21 0:00
 */
public class LeetCode102 {
    /**
     * 解法1 BFS
     * <p>
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 二叉树
     * @return 遍历结果
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                //本层元素放入集合
                TreeNode node = nodes.poll();
                list.add(node.val);
                //下层元素放入队列
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }

    /**
     * 解法2 DFS
     * <p>
     * 时间复杂度 O(N)
     * 空间复杂度 O(h) h为树的深度
     *
     * @param root 二叉树
     * @return 遍历结果
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        travel(root, 0, lists);
        return lists;
    }

    private void travel(TreeNode root, int level, List<List<Integer>> lists) {
        //层数
        if (lists.size() == level) {
            lists.add(new ArrayList<>());
        }
        lists.get(level).add(root.val);
        if (root.left != null) {
            travel(root.left, level + 1, lists);
        }
        if (root.right != null) {
            travel(root.right, level + 1, lists);
        }
    }
}
