package com.yanhuan.binarytree;

import com.yanhuan.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 寻找重复的子树
 *
 * @author YanHuan
 * @date 2020-12-20 13:02
 */
public class LeetCode652 {

    HashMap<String, Integer> memo = new HashMap<>();
    LinkedList<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        //左右子树的特征+本节点  就是整棵子树的特征 ==》后序遍历
        findDuplicate(root);
        return res;
    }

    private String findDuplicate(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String left = findDuplicate(root.left);
        String right = findDuplicate(root.right);

        String subTree = left + "," + right + "," + root.val;

        //校验mop中是否存在,不存在给0
        int freq = memo.getOrDefault(subTree, 0);
        //只添加重复一次的即可  多次忽略
        if (freq == 1) {
            res.add(root);
        }
        //给子树出现的次数+1
        memo.put(subTree, freq + 1);
        return subTree;
    }
}
