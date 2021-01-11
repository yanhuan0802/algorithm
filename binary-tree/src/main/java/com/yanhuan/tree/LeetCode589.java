package com.yanhuan.tree;

import com.yanhuan.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * N叉树的前序遍历
 *
 * @author YanHuan
 * @date 2021-01-11 22:30
 */
public class LeetCode589 {
    /**
     * 解法1：递归
     * 时间复杂度：O(M) M为节点个数
     * 空间复杂度：O(M) M为节点个数
     *
     * @param root 树
     * @return 遍历结果
     */
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    private void preorder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        for (Node child : root.children) {
            preorder(child, list);
        }
    }

    /**
     * 解法2：迭代
     * 时间复杂度：O(M) M为节点个数
     * 空间复杂度：O(M) M为节点个数
     *
     * @param root 树
     * @return 遍历结果
     */
    public List<Integer> preorder1(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            list.add(node.val);
            //将子节点逆序压入栈中，保证从最后取是前序遍历
            Collections.reverse(node.children);
            stack.addAll(node.children);
        }
        return list;
    }
}
