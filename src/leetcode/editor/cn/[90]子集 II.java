package leetcode.editor.cn;//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
// 
// 
// Related Topics 位运算 数组 回溯 👍 811 👎 0

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class SubsetsWithDupSolution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        StringBuilder key = new StringBuilder("");
        backtrack(nums,0);
        return res;
    }

    private void backtrack(int[] nums,int start){
        res.add(new LinkedList<>(track));
        for(int i=start;i<nums.length;i++){
            //排除相同相同元素的场景：
            if(i>start && nums[i]==nums[i-1]){
                continue;
            }
            track.addLast(nums[i]);
            backtrack(nums,i+1);
            track.removeLast();
        }
    }

    List<List<Integer>> res =  new LinkedList<>();
    HashSet<String> dp_table = new HashSet<>();

    LinkedList<Integer> track = new LinkedList<>();

    /**
     * 使用额外空间保存已出现的子集
     * @param nums
     * @param start
     * @param key
     */
    private void backtrackV2(int[] nums,int start,StringBuilder key){
        if(dp_table.contains(key.toString())){
            return;
        }
        dp_table.add(key.toString());
        res.add(new LinkedList<>(track));
        int keyLen = key.length();
        for(int i=start;i<nums.length;i++){
            track.addLast(nums[i]);
            key.append(":"+nums[i]);
            backtrackV2(nums,i+1,key);
            track.removeLast();
            key = key.replace(keyLen,key.length(),"");
        }
    }

    public static void main(String[] args) {
        SubsetsWithDupSolution solution = new SubsetsWithDupSolution();
        int[] nums = {1,2,2};
        solution.subsetsWithDup(nums);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
