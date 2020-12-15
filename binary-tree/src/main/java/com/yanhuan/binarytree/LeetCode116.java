package com.yanhuan.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充每个节点的下一个右侧节点指针
 *
 * @author YanHuan
 * @date 2020-12-15 23:40
 */
public class LeetCode116 {
    /**
     * 解法1
     *
     * @param root 树
     * @return 填充后的结果
     */
    public Node connect1(Node root) {
        if (root == null) {
            return null;
        }
        connectTwoNode(root.left, root.right);
        return root;
    }

    private void connectTwoNode(Node left, Node right) {
        if (left == null || right == null) {
            return;
        }
        //连接两个子节点
        left.next = right;

        //连接父节点相同的两个子节点
        connectTwoNode(left.left, left.right);
        connectTwoNode(right.left, right.right);

        //连接跨越父节点的子节点
        connectTwoNode(left.right, right.left);
    }


    /**
     * 解法2
     *
     * @param root 树
     * @return 填充后的结果
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        // 初始化队列同时将第一层节点加入队列中，即根节点
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // 外层的 while 循环迭代的是层数
        while (!queue.isEmpty()) {

            // 记录当前队列大小
            int size = queue.size();

            // 遍历这一层的所有节点
            for (int i = 0; i < size; i++) {

                // 从队首取出元素
                Node node = queue.poll();

                // 连接
                if (i < size - 1) {
                    node.next = queue.peek();
                }

                // 拓展下一层节点
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        // 返回根节点
        return root;
    }
}
