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
    int[][] pathSum;
    public int minPathSum(int[][] grid) {
        int m = grid.length,n=grid[0].length;
        pathSum = new int[m][n];
        for(int[] row:pathSum){
            Arrays.fill(row,-1);
        }
        //终点固定
        pathSum[0][n-1]=grid[0][n-1];
        return dp(grid,0,m-1);
    }

    private int dp(int[][] grid,int x,int y){
        if(x>=grid[0].length || y <0){
            return Integer.MAX_VALUE;
        }
        if(pathSum[x][y]>=0){
            return pathSum[x][y];
        }
        System.out.print("  ");
        pathSum[x][y] = grid[x][y]+Math.min(dp(grid,x,y-1),dp(grid,x+1,y));
        System.out.println("x="+x+";y="+y+";pathSum="+pathSum[x][y]);
        return pathSum[x][y];
    }

    public static void main(String[] args) {
        int[][] grip =  new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        MinPathSumSolution solution = new MinPathSumSolution();
        solution.minPathSum(grip);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
