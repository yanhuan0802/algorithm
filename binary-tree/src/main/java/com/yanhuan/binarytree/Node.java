package com.yanhuan.binarytree;

import lombok.Data;

/**
 * 完美二叉树
 *
 * @author YanHuan
 * @date 2020-12-15 23:39
 */
@Data
public class Node {
    int val;
    Node left;
    Node right;
    Node next;
}
