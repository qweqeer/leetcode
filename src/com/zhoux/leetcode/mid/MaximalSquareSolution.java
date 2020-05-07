package com.zhoux.leetcode.mid;

public class MaximalSquareSolution {

    /**
     * https://leetcode-cn.com/problems/maximal-square/comments/
     * @param matrix
     * @return
     */

    public static int maximalSquare(char[][] matrix) {
        if(null==matrix||matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int width = matrix.length;
        int height = matrix[0].length;
        int max = 0;
        int[][] hp = new int[width+1][height+1];
        for (int i = 1; i <= width; i++) {
            for (int j = 1; j <= height; j++) {
                if(matrix[i-1][j-1] == '1'){
                    hp[i][j] = Math.min(hp[i-1][j-1],Math.min(hp[i-1][j],hp[i][j-1]))+1;
                    max = Math.max(max,hp[i][j]);
                }
            }

        }
        return max*max;
//        int maxSide = 0;
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//            return maxSide;
//        }
//        int rows = matrix.length, columns = matrix[0].length;
//        int[][] dp = new int[rows+1][columns+1];
//        for (int i = 1; i <= rows; i++) {
//            for (int j = 1; j <= columns; j++) {
//                if (matrix[i-1][j-1] == '1') {
////                    if (i-1 == 0 || j-1 == 0) {
////                        dp[i][j] = 1;
////                    } else {
////
////                    }
//                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
//                    maxSide = Math.max(maxSide, dp[i][j]);
//                }
//            }
//        }
//        int maxSquare = maxSide * maxSide;
//        return maxSquare;
    }

    public static void main(String[] args) {
        char[][] matrix={
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        System.out.println(maximalSquare(matrix));
    }
}
