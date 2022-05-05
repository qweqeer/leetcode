package leetcode.editor.cn;//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
// Related Topics 数组 动态规划 矩阵 👍 1215 👎 0

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class MinPathSumSolution {
    /**
     * 需要注意数组和二维图对应关系
     * 左上角为坐标(0,0),右下角为(m,n)
     */
    int[][] memo;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n=grid[0].length;
        memo = new int[m][n];
        //初始化默认值
        for(int[] row:memo){
            Arrays.fill(row,-1);
        }
        // base case
        memo[m-1][n-1] = grid[m-1][n-1];
        //最右侧只能向下
        for(int i= m-2;i>=0;i--){
            memo[i][n-1] = grid[i][n-1]+ memo[i+1][n-1];
        }
        //最下方只能向右
        for(int j=n-2;j>=0;j--){
            memo[m-1][j] = grid[m-1][j]+ memo[m-1][j+1];
        }
        dp(grid,0,0);
        return memo[0][0];
    }

    private int dp(int[][] grid,int m,int n){
        if(memo[m][n]!=-1){
            return memo[m][n];
        }
        memo[m][n]=Math.min(dp(grid,m,n+1),dp(grid,m+1,n))+grid[m][n];
        System.out.println(String.format("m=%d;n=%d;sum=%d",m,n,memo[m][n]));
        return memo[m][n];
    }

    public static void main(String[] args) {
        int[][] grip =  new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        MinPathSumSolution solution = new MinPathSumSolution();
        solution.minPathSum(grip);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
