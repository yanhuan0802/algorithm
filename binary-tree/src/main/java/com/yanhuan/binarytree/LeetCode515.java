package com.yanhuan.binarytree;

import com.yanhuan.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 在每个树行中找最大值
 *
 * @author YanHuan
 * @date 2021-01-23 11:49
 */
public class LeetCode515 {
    /**
     * 解法1： 广度优先遍历
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root 树
     * @return 查找结果
     */
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                max = Math.max(max, node.val);
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            list.add(max);
        }
        return list;
    }

    /**
     * 解法2： 深度优先遍历
     * 时间复杂度：O(n)
     * 空间复杂度：O(h)
     *
     * @param root 树
     * @return 查找结果
     */
    public List<Integer> largestValues1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, 0, list);
        return list;
    }

    private void dfs(TreeNode root, int level, List<Integer> list) {
        //terminator
        if (root == null) {
            return;
        }
        //process logic in current level
        if (list.size() == level) {
            //当前层未放入
            list.add(root.val);
        }else {
            //当前层已放入  比大小
            list.set(level,Math.max(list.get(level), root.val));
        }
        //drill down
        dfs(root.left,level+1,list);
        dfs(root.right,level+1,list);
        //revert state
    }
}
