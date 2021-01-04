package com.yanhuan.map;

import java.util.Arrays;

/**
 * 有效的字母异位词
 *
 * @author YanHuan
 * @date 2021-01-04 22:13
 */
public class LeetCode242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);
        return Arrays.equals(chars, chars1);
    }
}
