package leetcode.editor.cn;//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 👍 3205 👎 0

import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class BracketsIsValidSolution {

    public boolean isValid(String s) {
        LinkedList<Character> queue = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(' ||c == '['||c=='{'){
                queue.addLast(c);
            }else{
                if(queue.isEmpty() || !isMatch(queue.removeLast(),c)){
                    return false;
                }
            }
        }
        return queue.isEmpty();
    }

    private boolean isMatch(char left,char right){
        if(right == ')' && left!='('){
            return false;
        }
        if(right == '}' && left!='{'){
            return false;
        }
        if(right == ']' && left!='['){
            return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
