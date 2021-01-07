package com.yanhuan.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 三数之和
 *
 * @author YanHuan
 * @date 2021-01-07 23:18
 */
public class LeetCode15 {
    /**
     * 排序+双指针
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     * @param nums 数组
     * @return 结果
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        List<List<Integer>> lists = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        //遍历
        for (int i = 0; i < nums.length; i++) {
            //如果当前元素大于0  那么后面的元素肯定也大于零  可直接返回
            if (nums[i] > 0) {
                return lists;
            }
            //跳过重复元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //双指针
            int curr = nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int tmp = curr + nums[l] + nums[r];
                if (tmp == 0) {
                    //将当前元素加入集合
                    lists.add(Arrays.asList(curr, nums[l], nums[r]));
                    //跳过重复元素
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    //左指针和右指针一起移动
                    l++;
                    r--;
                } else if (tmp > 0) {
                    //大于零  右指针左移
                    r--;
                } else {
                    //小于零  左指针右移
                    l++;
                }
            }
        }
        return lists;
    }
}
