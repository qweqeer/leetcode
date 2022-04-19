package leetcode.editor.cn;//给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
//
// 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bbbab"
//输出：4
//解释：一个可能的最长回文子序列为 "bbbb" 。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出：2
//解释：一个可能的最长回文子序列为 "bb" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 771 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class LongestPalindromeSubseqSolution {
    int[][] dp;
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        dp = new int[n][n];
        //dp[i][j]=dp[i-1][j-1]+2;
        for(int i=n-1;n>=0;i--){
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(i)){
                    dp[i][j]= dp[i+1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n-1];
    }

    private int maxLen(String str, int left,int right){
        if(left>=str.length() ||right<0)return 0;
        if(left==right){
            return 1;
        }
        if(str.charAt(left)!=str.charAt(right)){
            dp[left][right]= Math.max(maxLen(str,left,right-1),maxLen(str,left+1,right));
        }else{
            dp[left][right] = 2+maxLen(str,left+1,right-1);
        }
        return dp[left][right];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
