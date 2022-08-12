//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1845 👎 0

package leetcode.editor.cn;
public class P200_NumberOfIslands{
    public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P200_NumberOfIslands().new Solution();
          char[][] grid = {
                  {'1','1','1','1','0'},
                  {'1','1','0','1','0'},
                  {'1','1','0','0','0'},
                  {'0','0','1','0','1'}
          };
        System.out.println(solution.numIslands(grid));
    }
	 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
         int[][] direct =  {{1,0},{-1,0},{0,1},{0,-1}};
         boolean[][] visited;
         int n ;
         int m ;
    public int numIslands(char[][] grid) {
        n = grid.length;m = grid[0].length;
        visited = new boolean[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == '1'){
                    ans++;
                    clearLand(grid,i,j);
                }
            }
        }
        return ans;
    }

         private void clearLand(char[][] grid, int sr, int sc){
             if(sr<0||sr>=n||sc<0||sc>=m){
                 return;
             }
             if(visited[sr][sc]){
                 return;
             }
             if(grid[sr][sc] == '1'){
                 grid[sr][sc] = '0';
                 visited[sr][sc] = true;
                 for (int[] ints : direct) {
                     clearLand(grid,sr+ints[0],sc+ints[1]);
                 }
             }else{
                 visited[sr][sc] = true;
             }
         }
}
//leetcode submit region end(Prohibit modification and deletion)

}
