//给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t ，并返回该子串的长度。 
//
// 示例 1: 
//
// 输入: "eceba"
//输出: 3
//解释: t 是 "ece"，长度为3。
// 
//
// 示例 2: 
//
// 输入: "ccaabbb"
//输出: 5
//解释: t 是 "aabbb"，长度为5。
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 166 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

public class P159_LongestSubstringWithAtMostTwoDistinctCharacters {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P159_LongestSubstringWithAtMostTwoDistinctCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstringTwoDistinct("aa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstringTwoDistinct(String s) {
            int fast = 0, slow = 0;
            HashMap<Character, Integer> charNum = new HashMap<>();
            int ans = 0;
            while (fast < s.length()) {
                char curC = s.charAt(fast);
                int curNum = charNum.getOrDefault(curC, 0) + 1;
                charNum.put(curC, curNum);
                fast++;

                if (charNum.size() == 3) {
                    while (charNum.size() >= 3) {
                        char delC = s.charAt(slow);
                        int delNum = charNum.getOrDefault(delC, 0) - 1;
                        if (delNum == 0) {
                            charNum.remove(delC);
                        } else {
                            charNum.put(delC, delNum);
                        }
                        slow++;
                    }
                }

                if (charNum.size() <= 2) {
                    int totalNum = 0;
                    for (Integer value : charNum.values()) {
                        totalNum += value;
                    }
                    ans = Math.max(ans, totalNum);
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
