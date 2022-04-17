package leetcode.editor.cn;//给定两个字符串s1 和 s2，返回 使两个字符串相等所需删除字符的 ASCII 值的最小和 。
//
// 
//
// 示例 1: 
//
// 
//输入: s1 = "sea", s2 = "eat"
//输出: 231
//解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
//在 "eat" 中删除 "t" 并将 116 加入总和。
//结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
// 
//
// 示例 2: 
//
// 
//输入: s1 = "delete", s2 = "leet"
//输出: 403
//解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
//将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
//结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
//如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
// 
//
// 
//
// 提示: 
//
// 
// 0 <= s1.length, s2.length <= 1000 
// s1 和 s2 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 263 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class DeleteCharMinSumSolution {
        int[][] res;
        public int minimumDeleteSum(String s1, String s2) {
            int n = s1.length(),m = s2.length();
            //最大相同子串
            res = new int[n][m];
            for(int[] subRes:res){
                Arrays.fill(subRes,-1);
            }
            //dp[n][m] = Math.max(dp[n-1][m],dp[n][m-1]);
            return dp(s1,n-1,s2,m-1);
        }


        private int dp(String text1,int start1,String text2,int start2){
            if(start1<0 && start2<0){
                return 0;
            }else if(start2<0){
                return text1.charAt(start1)+dp(text1,start1-1,text2,start2);
            }else if(start1<0){
                return text2.charAt(start2)+dp(text1,start1,text2,start2-1);
            }
            if(res[start1][start2]>-1){
                return res[start1][start2];
            }
            if(text1.charAt(start1) == text2.charAt(start2)){
                res[start1][start2]=dp(text1,start1-1,text2,start2-1);
            }else{
                int value3 = dp(text1,start1-1,text2,start2-1)+ (int)text1.charAt(start1)+(int)text2.charAt(start2);
                int value2 = dp(text1,start1-1,text2,start2)+(int)text2.charAt(start2);
                int value1=dp(text1,start1,text2,start2-1)+(int)text2.charAt(start2);

                res[start1][start2] = Math.min(value1,Math.min(value2,value3));
            }
            return res[start1][start2];
        }
    }

//leetcode submit region end(Prohibit modification and deletion)
