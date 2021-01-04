package com.yanhuan.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 字母异位词分组
 *
 * @author YanHuan
 * @date 2021-01-04 22:49
 */
public class LeetCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        //按照排序后的str做分组条件进行分组
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(s -> {
                    char[] chars = s.toCharArray();
                    Arrays.sort(chars);
                    return new String(chars);
                })).values());
    }
}
