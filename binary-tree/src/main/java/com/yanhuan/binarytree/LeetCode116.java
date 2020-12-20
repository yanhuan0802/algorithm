package com.yanhuan.binarytree;

import com.yanhuan.Node;

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
    public Node connect2(Node root) {
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

    /**
     * 解法3
     *
     * @param root 树
     * @return 填充后的结果
     */
    public Node connect3(Node root) {
        if (root == null) {
            return null;
        }
        //从根节点开始
        Node leftmost = root;
        while (leftmost.next != null) {
            // 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
            Node head = leftmost;
            while (head != null) {
                //连接1
                head.left.next = head.right;

                //连接2
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                //指针向后移动
                head = head.next;
            }
            //去下一层最左的节点
            leftmost = leftmost.left;
        }
        return root;
    }

    /**
     * 解法4
     *
     * @param root 树
     * @return 填充后的结果
     */
    public Node connect4(Node root) {
        dfs(root);
        return root;
    }

    void dfs(Node root) {
        if (root == null) {
            return;
        }
        Node left = root.left;
        Node right = root.right;
        //以root为起点，将整个纵深这段串联起来
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        //递归的调用左右节点，完成同样的纵深串联
        dfs(root.left);
        dfs(root.right);
    }

    /**
     * 解法5（精妙）
     *
     * @param root 树
     * @return 填充后的结果
     */
    public Node connect5(Node root) {
        dfs(root, null);
        return root;
    }

    private void dfs(Node curr, Node next) {
        if (curr == null) {
            return;
        }
        curr.next = next;
        dfs(curr.left, curr.right);
        dfs(curr.right, curr.next == null ? null : curr.next.left);
    }
}
