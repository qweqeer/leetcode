//给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。如果不存在这样的 子数组 ，返回 
//-1 。 
//
// 子数组 是数组中 连续 的一部分。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1], k = 1
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2], k = 4
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,-1,2], k = 3
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁵ <= nums[i] <= 10⁵ 
// 1 <= k <= 10⁹ 
// 
// Related Topics 队列 数组 二分查找 前缀和 滑动窗口 单调队列 堆（优先队列） 👍 389 👎 0

package leetcode.editor.cn;

public class P862_ShortestSubarrayWithSumAtLeastK {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P862_ShortestSubarrayWithSumAtLeastK().new Solution();
        System.out.println(solution.shortestSubarray(new int[] {-34,37,51,3,-12,-50,51,100,-47,99,34,14,-13,89,31,-14,-44,23,-38,6 }, 151));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestSubarray(int[] nums, int k) {
            int ans = Integer.MAX_VALUE;
            int slow = 0, fast = 0;
            int sum = 0;
            while (fast < nums.length) {
                sum += nums[fast++];
                while (slow<fast && fast<=nums.length && sum-nums[slow]>=k){
                    ans = Math.min(fast - slow, ans);
                    sum-=nums[slow];
                    slow++;
                }
            }
            //TODO 待调试
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
