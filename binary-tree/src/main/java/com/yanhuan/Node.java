package com.yanhuan;

import lombok.Data;

/**
 * 完美二叉树
 *
 * @author YanHuan
 * @date 2020-12-15 23:39
 */
@Data
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
}
