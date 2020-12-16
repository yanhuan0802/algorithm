package com.yanhuan.binarytree;

/**
 * 构造最大二叉树
 * <p>
 * 构造树一般采用的是前序遍历，因为先构造中间节点，然后递归构造左子树和右子树。
 *
 * @author YanHuan
 * @date 2020-12-16 22:40
 */
public class LeetCode654 {


    /**
     * 解法1
     *
     * @param nums 数组
     * @return 最大二叉树
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return build(nums, 0, nums.length);
    }

    private TreeNode build(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return null;
        }
        //前序遍历
        //找到最大值对应的索引
        int maxIndex = lo;
        for (int i = lo; i < hi; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);

        //递归调用左右构造子树
        root.left = build(nums, lo, maxIndex);
        root.right = build(nums, maxIndex + 1, hi);
        return root;
    }
}
