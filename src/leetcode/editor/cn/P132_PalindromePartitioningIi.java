//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。 
//
// 返回符合要求的 最少分割次数 。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：1
//解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：s = "ab"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2000 
// s 仅由小写英文字母组成 
// 
// 
// 
// Related Topics 字符串 动态规划 👍 570 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P132_PalindromePartitioningIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P132_PalindromePartitioningIi().new Solution();
        System.out.println(solution.minCut("apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCut(String s) {
            int n = s.length();
            boolean[][] dp_table = new boolean[n][n];
            for (boolean[] row : dp_table) {
                Arrays.fill(row,true);
            }
            for (int i = n-1; i >=0; i--) {
                for(int j=i+1;j<n;j++){
                    dp_table[i][j] = (s.charAt(i) == s.charAt(j)) && dp_table[i+1][j-1];
                }
            }
            int[] size = new int[n];
            Arrays.fill(size,Integer.MAX_VALUE);
            for(int i=0;i<n;i++){
                if(dp_table[0][i]){
                    size[i]=0;
                    continue;
                }
                for (int j = 0; j < i; j++) {
                    if(dp_table[j+1][i]){
                        size[i] = Math.min(size[i],size[j]+1);
                    }
                }
            }
            return size[n-1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
