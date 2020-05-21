package com.zhoux.leetcode.mid;

public class LongestPalindromeSolution {
    /**
     * 寻找最大的回文字符串
     * https://leetcode-cn.com/problems/longest-palindromic-substring/
     *
     * @param str
     * @return
     */

    public static String longestPalindrome(String str) {
        if (null == str || str.length() < 1) {
            return str;
        }
        int max = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i - 1 < 0) {
                max = 1;
                continue;
            }
            int leftOffset = i - 1;
            int rightOffset = i + 1;
            boolean rightSuc = true;
            boolean leftSuc = true;
            /**
             * 连续与i位子相等
             */
            while (rightSuc || leftSuc) {
                if (leftOffset >= 0 && str.charAt(i) == str.charAt(leftOffset)) {
                    if (max < i - leftOffset + 1) {
                        max = i - leftOffset + 1;
                        left = leftOffset;
                        right = leftOffset + max - 1;
                    }
                    leftOffset--;

                } else
                    leftSuc = false;

                if (rightOffset < str.length() && str.charAt(i) == str.charAt(rightOffset)) {
                    if (max < rightOffset - leftOffset) {
                        max = rightOffset - leftOffset;
                        right = rightOffset;
                        left = rightOffset - max + 1;
                    }
                    rightOffset++;

                } else
                    rightSuc = false;
            }

            if (leftOffset < 0 || rightOffset >= str.length()) {
                continue;
            }
            /**
             * 最大连续相同字符两侧相等的字符计算
             */
            while (str.charAt(leftOffset) == str.charAt(rightOffset)) {
                int len = rightOffset - leftOffset + 1;
                if (max < len) {
                    left = leftOffset;
                    right = rightOffset;
                    max = len;
                }
                if (--leftOffset < 0 || ++rightOffset >= str.length()) {
                    break;
                }
            }
        }
        return str.substring(left, right + 1);
    }

    /**
     * 中心扩散的方法，其实做了很多重复计算。动态规划就是为了减少重复计算的问题。动态规划听起来很高大上。其实说白了就是空间换
     * 时间，将计算结果暂存起来，避免重复计算。作用和工程中用 redis 做缓存有异曲同工之妙。
     * 我们用一个 boolean dp[l][r] 表示字符串从 i 到 j 这段是否为回文。试想如果 dp[l][r]=true，我们要判断 dp[l-1][r+1] 是否
     * 为回文。只需要判断字符串在(l-1)和（r+1)两个位置是否为相同的字符，是不是减少了很多重复计算。
     * 进入正题，动态规划关键是找到初始状态和状态转移方程。
     * 初始状态，l=r 时，此时 dp[l][r]=true。
     * 状态转移方程，dp[l][r]=true 并且(l-1)和（r+1)两个位置为相同的字符，此时 dp[l-1][r+1]=true。
     *
     * @param s
     * @return
     */
    public static String longestPalindromeV2(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度

        boolean[][] dp = new boolean[strLen][strLen];

        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;

                    }
                }

            }

        }
        return s.substring(maxStart, maxEnd + 1);
    }

    /**
     * 中心扩散法
     *
     * @param str
     * @return
     */
    public static String longestPalindromeV3(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }
        int strLen = str.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度

        boolean[][] dp = new boolean[strLen][strLen];

        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                if (str.charAt(l) == str.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }
        return str.substring(maxStart, maxEnd + 1);
    }

    public static void main(String[] args) {
        String str = "adnghchg";
        System.out.println(longestPalindromeV3("aaabaaaa"));
        System.out.println(longestPalindromeV3("aa"));
        System.out.println(longestPalindromeV3("cbbd"));
        System.out.println(longestPalindromeV3("adnghchg"));
        System.out.println(longestPalindromeV3("baaab"));
        System.out.println(longestPalindromeV3("ababcba"));
        System.out.println(longestPalindromeV3("baabc"));
        System.out.println(longestPalindromeV3("abaabacba"));
    }
}
