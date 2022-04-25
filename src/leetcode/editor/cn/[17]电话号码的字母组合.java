package leetcode.editor.cn;//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 1863 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class LetterCombinationsSolution {
    HashMap<String,List<String>> cache = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if(null == digits || digits.length()==0){
            return new ArrayList<>();
        }
        init();
        return traverse(digits);
    }

    private List<String> traverse(String key){
        if(!cache.containsKey(key)){
            List<String> subList = traverse( key.substring(1));
            List<String> res = new ArrayList<>();
            List<String> prefixList= cache.get(key.substring(0,1));
            for (String s : prefixList) {
                for (String s1 : subList) {
                    res.add(s+s1);
                }
            }
            cache.put(key,res);
            return res;
        }else{
            return cache.get(key);
        }
    }

    private void init(){
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("a");
        list2.add("b");
        list2.add("c");
        cache.put("2",list2);

        ArrayList<String> list3 = new ArrayList<String>();
        list3.add("d");
        list3.add("e");
        list3.add("f");
        cache.put("3",list3);

        ArrayList<String> list4 = new ArrayList<String>();
        list4.add("g");
        list4.add("h");
        list4.add("i");
        cache.put("4",list4);

        ArrayList<String> list5 = new ArrayList<String>();
        list5.add("j");
        list5.add("k");
        list5.add("l");
        cache.put("5",list5);

        ArrayList<String> list6 = new ArrayList<String>();
        list6.add("m");
        list6.add("n");
        list6.add("o");
        cache.put("6",list6);

        ArrayList<String> list7 = new ArrayList<String>();
        list7.add("p");
        list7.add("q");
        list7.add("r");
        list7.add("s");
        cache.put("7",list7);

        ArrayList<String> list8 = new ArrayList<String>();
        list8.add("t");
        list8.add("u");
        list8.add("v");
        cache.put("8",list8);

        ArrayList<String> list9 = new ArrayList<String>();
        list9.add("w");
        list9.add("x");
        list9.add("y");
        list9.add("z");
        cache.put("9",list9);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
