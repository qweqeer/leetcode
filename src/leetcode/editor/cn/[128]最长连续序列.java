package leetcode.editor.cn;//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics 并查集 数组 哈希表 👍 1244 👎 0

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class LongestConsecutiveSolution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int value = nums[0],res = 1;
        int temp = 1;
        for(int i=1;i<nums.length;i++){
            //防止大于Integer.MAX_VALUE
            if(value== nums[i]-1){
                temp++;
                res = Math.max(temp,res);
            }else if(nums[i] == value){
                continue;
            }else {
                temp=1;
            }
            value = nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        LongestConsecutiveSolution solution = new LongestConsecutiveSolution();
        /**
         * case1: 最大值，最小值
         * case2: 数组为空
         * case3: 最长序列为1
         * case4: 存在相同元素
         */

        int[] nums = {199,300,1,Integer.MAX_VALUE,Integer.MAX_VALUE-1,Integer.MIN_VALUE,Integer.MIN_VALUE+1,Integer.MIN_VALUE+2};
        System.out.println(solution.longestConsecutive(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
