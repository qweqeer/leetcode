package leetcode.editor.cn;//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
//
// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
// 
//
// 示例 2： 
//
// 
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//     注意，你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s 和 wordDict[i] 仅有小写英文字母组成 
// wordDict 中的所有字符串 互不相同 
// 
// Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 👍 1580 👎 0

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modifiWation and deletion)
class WordBreakSolution {
    Set<String> wordSet;
    int[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        wordSet = wordDict.stream().collect(Collectors.toSet());
        dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return backstrack(s,0);
    }

    private boolean backstrack(String s,int start){
        if(start>=s.length()){
            return true;
        }
        if(dp[start]!=-1){
            return dp[start]==1;
        }
        // 需要注意dp表的设值时机，方式未执行的case被覆盖
        boolean isMatch = false;
        for(int i=start;i<s.length();i++) {
            String word = s.substring(start, i + 1);
            isMatch = wordSet.contains(word) && backstrack(s, i + 1);
            if(isMatch){
                break;
            }
        }
        dp[start] = isMatch?1:0;
        return isMatch;
    }

    public static void main(String[] args) {
        WordBreakSolution solution = new WordBreakSolution();
        String str="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        // String str="goalspecial";
        List<String> word = new ArrayList<>();
        word.add("go");
        word.add("goal");
        word.add("goals");
        word.add("a");
        word.add("aa");
        word.add("aaa");
        word.add("aaaa");
        word.add("aaaaa");
        word.add("aaaaaa");
        word.add("aaaaaaa");
        word.add("aaaaaaaa");


        System.out.println(solution.wordBreak(str,word));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
