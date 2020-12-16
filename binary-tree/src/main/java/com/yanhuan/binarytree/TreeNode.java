package com.yanhuan.binarytree;

import lombok.Data;

/**
 * 二叉树
 *
 * @author YanHuan
 * @date 2020-12-15 23:10
 */
@Data
public class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
    }
}
