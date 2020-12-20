package com.yanhuan;

import lombok.Data;

/**
 * 二叉树
 *
 * @author YanHuan
 * @date 2020-12-15 23:10
 */
@Data
public class TreeNode {
    public int val;
    public TreeNode left, right;

    /**
     * 如何让每一个节点知道自己的排名呢？
     * <p>
     * 需要在二叉树节点中维护额外信息。每个节点需要记录，以自己为根的这棵二叉树有多少个节点。
     */
    public int size;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
