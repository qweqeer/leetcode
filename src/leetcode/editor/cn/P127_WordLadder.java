//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> 
//s2 -> ... -> sk： 
//
// 
// 每一对相邻的单词只差一个字母。 
// 对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。 
// sk == endWord 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 
//中的 单词数目 。如果不存在这样的转换序列，返回 0 。 
// 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
// Related Topics 广度优先搜索 哈希表 字符串 👍 1040 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class P127_WordLadder {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P127_WordLadder().new Solution();
        List<String> wordList = convertToList(new String[] { "hot","dot","dog","lot","log","cog","hig","hog"});
        System.out.println(solution.ladderLength("hit" ,"cog", wordList));
    }

    private static List<String> convertToList(String[] arr) {
        List<String> wordList = new ArrayList<>();
        for (String s : arr) {
            wordList.add(s);
        }
        return wordList;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[] used;
        //TODO 执行效率待优化，超时
        HashMap<String,Integer> dp_table = new HashMap<>();

        HashMap<String, Integer> wordAndIndex = new HashMap<>();
        HashMap<Integer,List<Integer>> wordNextIndex = new HashMap<>();

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            wordList.add(beginWord);
            // 构建图
            for (int i = 0; i < wordList.size(); i++) {
                wordAndIndex.put(wordList.get(i), i);
                wordNextIndex.put(i,getNextMatchedIndex(wordList,wordList.get(i)));
            }
            if (!wordAndIndex.containsKey(endWord)) {
                return 0;
            }
            used = new boolean[wordList.size()];
            int res = find(wordAndIndex.get(beginWord),1,wordList,endWord);
            return res == Integer.MAX_VALUE?0:res;
        }

        private int find(int index,int num,List<String> wordList,String endWord){
            if(wordList.get(index).equals(endWord)){
                return num;
            }
            List<Integer> indexs = wordNextIndex.get(index);
            if(null == indexs || indexs.size()==0){
                return  Integer.MAX_VALUE;
            }
            String key = num+":"+index;
            if(dp_table.containsKey(key)){
                return dp_table.get(key);
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < indexs.size(); i++) {
                if(used[indexs.get(i)]){
                    continue;
                }
                used[indexs.get(i)] = true;
                ans = Math.min(ans,find(indexs.get(i),num+1,wordList,endWord));
                used[indexs.get(i)] = false;
            }
            dp_table.put(key,ans);
            return ans;
        }




        private List<Integer> getNextMatchedIndex(List<String> wordList, String curWord) {
            List<Integer> words = new ArrayList<>();
            for (int i = 0; i < wordList.size(); i++) {
                int diff = 0;
                int offset = 0;
                while (offset < curWord.length()) {
                    if (curWord.charAt(offset) != wordList.get(i).charAt(offset)) {
                        diff++;
                    }
                    offset++;
                }
                if (diff == 1) {
                    words.add(i);
                }
            }
            return words;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
