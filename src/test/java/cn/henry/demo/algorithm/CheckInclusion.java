package cn.henry.demo.algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * 字符串的排列
 */
public class CheckInclusion {

    /**
     * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
     *
     * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
     *
     * 示例1:
     *
     * 输入: s1 = "ab" s2 = "eidbaooo"
     * 输出: True
     * 解释: s2 包含 s1 的排列之一 ("ba").
     */
    @Test
    public void test() {
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean s = checkInclusion(s1,s2);
        System.out.println(s);
    }

    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[] c1 = new int[26];
        int[] c2 = new int[26];

        for (char c : s1.toCharArray()) {
            c1[c - 'a']++;
        }

        for (int i = 0; i < len2; i++) {
            if (i >= len1)
                //todo 这一步没看懂
                --c2[s2.charAt(i - len1) - 'a'];//先把坐标查过的减掉
            c2[s2.charAt(i) - 'a']++;
            if (Arrays.equals(c1, c2))
                return true;
        }
        return false;
    }
}
