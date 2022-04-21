package leetcode.editor.cn;//给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
//
// 返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的
//字符 c 的 距离 。 
//
// 两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "loveleetcode", c = "e"
//输出：[3,2,1,0,1,0,0,1,2,2,1,0]
//解释：字符 'e' 出现在下标 3、5、6 和 11 处（下标从 0 开始计数）。
//距下标 0 最近的 'e' 出现在下标 3 ，所以距离为 abs(0 - 3) = 3 。
//距下标 1 最近的 'e' 出现在下标 3 ，所以距离为 abs(1 - 3) = 2 。
//对于下标 4 ，出现在下标 3 和下标 5 处的 'e' 都离它最近，但距离是一样的 abs(4 - 3) == abs(4 - 5) = 1 。
//距下标 8 最近的 'e' 出现在下标 6 ，所以距离为 abs(8 - 6) = 2 。
// 
//
// 示例 2： 
//
// 
//输入：s = "aaab", c = "b"
//输出：[3,2,1,0]
// 
//
// 
//提示：
//
// 
// 1 <= s.length <= 10⁴ 
// s[i] 和 c 均为小写英文字母 
// 题目数据保证 c 在 s 中至少出现一次 
// 
// Related Topics 数组 双指针 字符串 👍 263 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class ShortestToCharSolution {
    /**
     * 使用双指针处理，时间复杂度极端情况在O(n²)，空间复杂度在O(1)
     * @param s
     * @param c
     * @return
     */
    public int[] shortestToChar(String s, char c) {
        int[] ans = new int[s.length()];
        for (int i=0;i<s.length();i++){
            ans[i] = findC(s,i,c);
        }
        return ans;
    }

    private int findC(String s,int i,char c){
        if(s.charAt(i) == c){
            return 0;
        }
        int left = i-1;
        int right = i+1;
        boolean canFind = true;
        while (canFind){
            if(left>=0 &&s.charAt(left) == c){
                return Math.abs(left-i);
            }else{
                left--;
            }
            if(right<s.length() && s.charAt(right) == c){
                return Math.abs(right-i);
            }else{
                right++;
            }
            if(left<0 && right>=s.length()){
                canFind=false;
            }
        }
        return Integer.MAX_VALUE;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
