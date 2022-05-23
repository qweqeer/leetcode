//给定两个字符串 s 和 t ，如果它们的编辑距离为 1 ，则返回 true ，否则返回 false 。 
//
// 字符串 s 和字符串 t 之间满足编辑距离等于 1 有三种可能的情形： 
//
// 
// 往 s 中插入 恰好一个 字符得到 t 
// 从 s 中删除 恰好一个 字符得到 t 
// 在 s 中用 一个不同的字符 替换 恰好一个 字符得到 t 
// 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "ab", t = "acb"
//输出: true
//解释: 可以将 'c' 插入字符串 s 来得到 t。
// 
//
// 示例 2: 
//
// 
//输入: s = "cab", t = "ad"
//输出: false
//解释: 无法通过 1 步操作使 s 变为 t。 
//
// 
//
// 提示: 
//
// 
// 0 <= s.length, t.length <= 10⁴ 
// s 和 t 由小写字母，大写字母和数字组成 
// 
// Related Topics 双指针 字符串 👍 101 👎 0

package leetcode.editor.cn;

public class P161_OneEditDistance {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P161_OneEditDistance().new Solution();
        System.out.println(solution.isOneEditDistance("ab","acb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isOneEditDistance(String s, String t) {

            int diff = 0;
            if(s.length()<t.length()){
                String temp = s;
                s = t;
                t = temp;
            }
            int sl = s.length(),tl = t.length();
            if(sl-tl>1){
                return false;
            }else if(sl == 0){
                return false;
            }else if(tl == 0){
                return true;
            }

            int si = 0,ti=0;
            while (diff<=1 && si< sl){
                if(ti>=tl){
                    diff++;
                    si++;ti++;
                }else if(s.charAt(si) == t.charAt(ti)){
                    si++;ti++;
                }else{
                    diff++;
                    if(sl == tl){
                        si++;ti++;
                    }else{
                        si++;
                    }
                }
            }
            return diff==1;
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}
