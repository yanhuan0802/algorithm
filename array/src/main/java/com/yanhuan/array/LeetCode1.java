package com.yanhuan.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author YanHuan
 * @date 2021-01-02 22:57
 */
public class LeetCode1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
