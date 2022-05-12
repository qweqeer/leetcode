//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
// Related Topics 数组 二分查找 分治 👍 5428 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class P4_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P4_MedianOfTwoSortedArrays().new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{1,2},new int[]{3,5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len1 = nums1.length, len2 = nums2.length;
            int[] nums = new int[len1+len2];
            int point1 = 0,point2=0;
            for (int i = 0; i < nums.length; i++) {
                int val1 = point1 >=len1?Integer.MAX_VALUE:nums1[point1];
                int val2 = point2 >=len2?Integer.MAX_VALUE:nums2[point2];
                if(val1<=val2){
                    nums[i]=val1;
                    point1++;
                }else{
                    nums[i]=val2;
                    point2++;
                }
            }
            int mid = (len1+len2)/2;
            boolean isDouble = (len1+len2)%2==0;

            return isDouble?(double) (nums[mid]+nums[mid-1])/2:nums[mid];
        }



    }
    //leetcode submit region end(Prohibit modification and deletion)
}
