//字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。 
//
// 
//
// 示例 1: 
//
// 输入: 
//first = "pale"
//second = "ple"
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: 
//first = "pales"
//second = "pal"
//输出: False
// 
// Related Topics 双指针 字符串 👍 180 👎 0

package leetcode.editor.cn;
public class P面试题_0105_OneAwayLcci{
    public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P面试题_0105_OneAwayLcci().new Solution();
    }
	 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean oneEditAway(String first, String second) {
        if(Math.abs(first.length()-second.length())>1){
            return false;
        }
        /**
         * 为模拟操作，如果出现不一样的字符
         * 两种选择：
         * =>跳过，等价与删除和插入一个字符
         * =>替换=> 替换操作必须字符串
         */

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
