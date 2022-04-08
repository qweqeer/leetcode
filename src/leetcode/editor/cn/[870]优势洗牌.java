//给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
//
// 返回 A 的任意排列，使其相对于 B 的优势最大化。 
//
// 
//
// 示例 1： 
//
// 输入：A = [2,7,11,15], B = [1,10,4,11]
//输出：[2,11,7,15]
// 
//
// 示例 2： 
//
// 输入：A = [12,24,8,32], B = [13,25,32,11]
//输出：[24,32,8,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length = B.length <= 10000 
// 0 <= A[i] <= 10^9 
// 0 <= B[i] <= 10^9 
// 
// Related Topics 贪心 数组 排序 
// 👍 174 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collector;

class SolutionAdvantageCount {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        //降序处理，最大的先使用
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (int i = 0; i < nums2.length; i++) {
            priorityQueue.offer(new int[]{i, nums2[i]});
        }
        Arrays.sort(nums1);
        int right = nums1.length - 1, left = 0;
        int[] result = new int[nums1.length];
        while (!priorityQueue.isEmpty()) {
            int[] value = priorityQueue.poll();
            if (nums1[right] > value[1]) {
                result[value[0]] = nums1[right];
                right--;
            } else {
                result[value[0]] = nums1[left];
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Math.abs(-1));

    }

}
//leetcode submit region end(Prohibit modification and deletion)
