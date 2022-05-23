//几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？ 
//
// 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。 
//
// 例 1： 
//
// 
//输入: m = 3, n = 3, k = 5
//输出: 3
//解释: 
//乘法表:
//1	2	3
//2	4	6
//3	6	9
//
//第5小的数字是 3 (1, 2, 2, 3, 3).
// 
//
// 例 2： 
//
// 
//输入: m = 2, n = 3, k = 6
//输出: 6
//解释: 
//乘法表:
//1	2	3
//2	4	6
//
//第6小的数字是 6 (1, 2, 2, 3, 4, 6).
// 
//
// 注意： 
//
// 
// m 和 n 的范围在 [1, 30000] 之间。 
// k 的范围在 [1, m * n] 之间。 
// 
// Related Topics 二分查找 👍 245 👎 0

package leetcode.editor.cn;

public class P668_KthSmallestNumberInMultiplicationTable {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P668_KthSmallestNumberInMultiplicationTable().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 问题转换=> 小于K的数转换为小于X的数的个数
         * @param m
         * @param n
         * @param k
         * @return
         */
        public int findKthNumber(int m, int n, int k) {
            int left = 1, right = m * n;
            while (left < right) {
                //获取乘积的中位数
                int mid = left + (right - left) / 2;
                //找到小于mid的数的个数
                int count = mid / n * n;
                //计算count的数量根据乘法表格式确定=>二维数组
                for (int i = mid / n + 1; i <= m; i++) {
                    count += mid / i;
                }
                //如果小于MID的数量小于K，则说明第K小的数据在右半区
                if (count < k) {
                    left = mid + 1;
                } else {
                    //
                    right = mid;
                }
            }
            return left;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
