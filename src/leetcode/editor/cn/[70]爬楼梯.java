package leetcode.editor.cn;//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
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
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 2361 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class ClimbingStairsSolution {
    int[] dp;
    public int climbStairsV2(int n) {
        dp = new int[n+1];
        if(n==1){
            return 1;
        }
        if(n == 2){
            return  2;
        }
        dp[1] = 1;
        dp[2] = 2;
        climb(n);
        return dp[n];
    }
    private int climb(int n){
        if(n<=2){
            return dp[n];
        }
        if(dp[n]>0){
            return dp[n];
        }
        dp[n] = climb(n-1)+ climb(n-2);
        return  dp[n];
    }

    /**
     * 交换数组
     * @param n
     * @return
     */
    public  int climbStairs(int n){
        if(n==1){
            return 1;
        }
        if(n == 2){
            return  2;
        }
        int[] dp = new int[n];
        dp[0]=1;dp[1]=2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[0]+dp[1];
        }
        return dp[n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
