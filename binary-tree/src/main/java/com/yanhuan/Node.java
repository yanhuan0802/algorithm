package com.yanhuan;

import java.util.List;

/**
 * N叉树
 *
 * @author YanHuan
 * @date 2021-01-11 22:28
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
