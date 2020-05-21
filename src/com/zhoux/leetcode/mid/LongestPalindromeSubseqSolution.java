package com.zhoux.leetcode.mid;

/**
 * @author:treey
 * @create:2020/5/21
 **/
public class LongestPalindromeSubseqSolution {
    /**
     * 最大回文子序列
     * https://leetcode-cn.com/problems/longest-palindromic-subsequence/
     */

    public static int longestPalindromeSubseq(String s) {
        int sLen =s.length();
        int[][] dp = new int[sLen][sLen];
        for (int i = sLen-1; i >=0; i--) {
            dp[i][i]=1;
            for (int j = i+1; j <sLen ; j++) {
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1]+2;
                }else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
                
            }
        }
        return dp[0][sLen-1];
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
    }
}
