package leetcode.editor.cn;//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 栈 字符串 动态规划 👍 1790 👎 0

import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class LongestValidParenthesesSolution {

    /**
     * 动态规划+备忘录
     * @param s
     * @return
     */
    // public int longestValidParentheses(String s) {
    //     int[] dp = new int[s.length()+1];
    //     int n = s.length();
    //     for (int i = 1; i < n-1; i++) {
    //         char c = s.charAt(i);
    //         if(c == ')'){
    //             if(s.charAt(i-1)=='('){
    //                 dp[i]=(i>2?dp[i-2]:0)+2;
    //             }else if (){
    //
    //             }
    //         }
    //     }
    //
    // }

    /**
     * 使用栈
     * @param s
     * @return
     */
    public int longestValidParenthesesV2(String s) {
        Stack<Integer> stack = new Stack<>();
        int curLen = 0,res = 0;
        int n = s.length();
        stack.add(-1);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    res = Math.max(res,i-stack.peek());
                }
            }
        }
        return res;
    }

    /**
     * 2 * O(n)
     * @param s
     * @return
     */
    public int longestValidParenthesesV3(String s) {
        /**
         * 1、子串必须以左括号开始
         * 2、左括号数等于右括号数=>有效括号对子串
         * 3、有括号大于左括号，子串不可能是有效子串=>左括号数据和右括号数据重置
         * 问题：(() 又左到右的遍历方式，无法解决left>right的情况 =>反向遍历一次
         *
         */
        int n = s.length();
        int left=0,right=0;
        int res = 0;
        for(int i=0;i<n;i++){
            if(s.charAt(i) == ')'){
                right++;
            }else {
                left++;
            }
            if(left == right){
                res = Math.max(res,right*2);
            }else if(right>left){
                right = left = 0;
            }
        }
        right = left = 0;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i) == ')'){
                right++;
            }else {
                left++;
            }
            if(left == right){
                res = Math.max(res,right+left);
            }else if(right<left){
                right = left = 0;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
