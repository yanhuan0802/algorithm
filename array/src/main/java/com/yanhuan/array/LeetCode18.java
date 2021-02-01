package com.yanhuan.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 四数之和
 *
 * @author YanHuan
 * @date 2021-02-01 23:23
 */
public class LeetCode18 {
    /**
     * 排序+双指针
     * 时间复杂度O(n^3)
     * 空间复杂度O(logN)
     *
     * @param nums   数组
     * @param target 目标数
     * @return 四元组结果
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //1. 特判
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        //2. 排序
        Arrays.sort(nums);
        //3. 遍历
        List<List<Integer>> lists = new ArrayList<>();
        int length = nums.length;
        //第一层
        for (int i = 0; i < nums.length - 3; i++) {
            //如果当前结果大于目标值  结束循环
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            //如果当前值加最后三个数小于目标值 跳过本次循环
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //第二层
            for (int j = i + 1; j < nums.length - 2; j++) {
                //如果当前结果大于目标值  结束循环
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                //如果当前值加最后两个数小于目标值 跳过本次循环
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                //去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                //爽指针
                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        lists.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    } else if (sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return lists;
    }
}
