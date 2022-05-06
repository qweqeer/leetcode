package leetcode.editor.cn;//给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//提示：
//
// 
// n == nums.length 
// 1 <= n <= 5 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
// Related Topics 数组 哈希表 分治 计数 排序 👍 1430 👎 0

import java.util.Arrays;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class MajorityElementSolution {

    public int majorityElement(int[] nums) {
        //排序
        return majorityElementBySort(nums);
    }
    /**
     * 采用排序算法
     * 时间O(n*logn)
     * 空间O(n*logn)
     * @param nums
     * @return
     */
    public int majorityElementBySort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     * 哈希表
     * 时间：O(n)
     * 空间：O(1)
     * @param nums
     * @return
     */
    public int majorityElementByHashMap(int[] nums) {
        HashMap<Integer,Integer> numTimes = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            int value = numTimes.getOrDefault(num,1);
            max = Math.max(++value,max);
            numTimes.put(num,value);
        }
        return max;
    }

    /**
     * 二分法(分治)
     * 时间:O(logN)
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public int majorityElementByBinary(int[] nums,int start,int end) {
        //TODO 待实现
        return  -1;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
