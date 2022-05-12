//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 1171 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class P347_TopKFrequentElements {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P347_TopKFrequentElements().new Solution();
        int[] nums = {1,1,1,2,2,3};
        int[] ans  = solution.topKFrequent(nums,2);
        System.out.println("done");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] topKFrequent(int[] nums, int k) {
            //排序处理 时间复杂度O(N+logN)
            return bySort(nums,k);
        }

        private int[] bySort(int[] nums,int k){
            HashMap<Integer,Integer> valueTimes = new HashMap<>();
            for (int num : nums) {
                valueTimes.put(num,valueTimes.getOrDefault(num,0)+1);
            }
            PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
            for (Map.Entry<Integer, Integer> integerIntegerEntry : valueTimes.entrySet()) {
                queue.add(integerIntegerEntry);
            }
            int[] ans = new int[k];
            for (int i = 0; i < k; i++) {
                if(!queue.isEmpty()){
                    ans[i]=queue.poll().getKey();
                }
            }
            return ans;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
