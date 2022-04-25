package leetcode.editor.cn;//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2587 👎 0

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class GenerateParenthesisSolution {

    char[] brackets = {'(',')'};

    public List<String> generateParenthesis(int n) {
        /**
         * 有效的情况下：
         * 1、左括号永远大于等于右括号
         * 2、在括号数大于右括号时，每次均有两种插入选择：(、)
         */
        List<String> res  =new ArrayList<>();
        backtrack(res,"",0,0,n);
        return res;
    }

    private void backtrack(List<String> res,String cur, int left,int right,int n){
        if(cur.length() == n*2){
            res.add(cur);
        }
        //优先添加左括号
        if(left<n){
            backtrack(res,cur+"(",left+1,right,n);
        }
        if(right<left){
            backtrack(res,cur+")",left,right+1,n);
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)
