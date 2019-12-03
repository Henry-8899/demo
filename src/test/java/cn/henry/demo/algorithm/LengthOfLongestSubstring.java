package cn.henry.demo.algorithm;

import org.junit.Test;

import java.util.HashMap;

public class LengthOfLongestSubstring {


    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */
    @Test
    public void test() {
        String s = "abadabade";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    /**
     * 复杂度 O(n)
     * @param str
     * @return
     */
    public static int lengthOfLongestSubstring(String str) {
        if (str == null || str.length() == 0) return 0;

        HashMap<Character, Integer> temp = new HashMap<>();
        char[] chars = str.toCharArray();

        int res = 0, start = 0;
        for (int i = 0; i < chars.length; i++) {
            if (temp.containsKey(chars[i])) {
                start = Math.max(temp.put(chars[i], i) + 1, start);
            }

            temp.put(chars[i], i);
            res = Math.max(res, i - start + 1);

        }

        return res;
    }
}
