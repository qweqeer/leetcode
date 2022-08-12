//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
//
// Related Topics 记忆化搜索 数学 动态规划 👍 2575 👎 0

package leetcode.editor.cn;
public class P70_ClimbingStairs{
    public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P70_ClimbingStairs().new Solution();
        System.out.println(solution.climbStairs(10));
    }
	 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        int[] dp_table = new int[n+1];
        //basecase
        dp_table[1] = 1;
        dp_table[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp_table[i] = dp_table[i-1]+dp_table[i-2];
        }
        return dp_table[n];
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
