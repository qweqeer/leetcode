package com.zhoux.leetcode.mid;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author:treey
 * @create:2020/5/20
 **/
public class FindTheLongestSubstringSolution {
    /**
     * 每个元音字母包含偶数次的最长字符串
     * https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/
     * 元音字母 'a'，'e'，'i'，'o'，'u'
     */

    public static int findTheLongestSubstring(String s) {
        /**
         * 1、五位二进制保存5个元音字母出现的奇偶
         * 2、
         */
        int ans = 0, status = 0, n = s.length();
        int[] pos = new int[1<<5];
        Arrays.fill(pos, -1);
        pos[0]=0;
        for (int i = 0; i < n; i ++) {
            if (s.charAt(i) == 'a') {
                status ^= 1<<0;
            } else if (s.charAt(i) == 'e') {
                status ^= 1<<1;
            } else if (s.charAt(i) == 'i') {
                status ^= 1<<2;
            } else if (s.charAt(i) == 'o') {
                status ^= 1<<3;
            } else if (s.charAt(i) == 'u') {
                status ^= 1<<4;
            }
            if (pos[status] >=0) {
                ans = Math.max(ans, i + 1 - pos[status]);
            } else {
                pos[status] = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findTheLongestSubstring("leetcodeisgreat"));
    }

}
