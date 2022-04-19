package leetcode.editor.cn;//给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
//
// 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第
//一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1
//, col + 1) 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
//输出：13
//解释：如图所示，为和最小的两条下降路径
// 
//
// 示例 2： 
//
// 
//
// 
//输入：matrix = [[-19,57],[-40,-5]]
//输出：-59
//解释：如图所示，为和最小的下降路径
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 100 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 动态规划 矩阵 
// 👍 165 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class MinFallingPathSumSolution {
    int[] dp;
    int boardLen=0;
    public int minFallingPathSum(int[][] matrix) {
        boardLen = matrix.length;
        dp = new int[matrix.length*matrix.length];
        Arrays.fill(dp,20000);
        int minPathSum = 20000;
        for (int cel = 0;cel<boardLen;cel++){
            minPathSum = Math.min(traversePathSum(matrix,0,cel),minPathSum);
        }
        return minPathSum;
    }

    private int traversePathSum(int[][] matrix,int row,int cel){
        if(cel<0 || cel>=boardLen){
            return 20000;
        }
        if(boardLen-1 == row){
            return matrix[row][cel];
        }
        int index = row*boardLen+cel;
        if(dp[index]!=20000){
            return dp[index];
        }

        int min = Math.min(traversePathSum(matrix,row+1,cel-1),traversePathSum(matrix,row+1,cel));
        min= Math.min(min,traversePathSum(matrix,row+1,cel+1));
        dp[index] = matrix[row][cel] + min;
        return dp[index];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
