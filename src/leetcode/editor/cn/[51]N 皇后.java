package leetcode.editor.cn;//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
// 
// 
// Related Topics 数组 回溯 
// 👍 1275 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class NQueensSolution {

    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j]='.';
            }
        }
        traverse(board,new ArrayList<>(),0);
        return ans;
    }

    private void traverse(char[][] board,List<String> temp,int row){
        if(temp.size() == board.length){
            ans.add(temp);
            return;
        }
        for(int i=0;i<board.length;i++){
            if(!isValid(board,row,i)){
                continue;
            }
            // 当前节点符合放皇后的条件
            board[row][i] = 'Q';
            List<String> newList=new ArrayList<>(temp);
            newList.add(String.valueOf(board[row]));
            traverse(board,newList,row+1);
            board[row][i] = '.';
        }
    }

    //校验当前节点是否合法
    private boolean isValid(char[][] board,int row,int cel){
        //上方
        for (int i = 0; i < row; i++) {
            if(board[i][cel] == 'Q'){
                return false;
            }
        }

        //左上方
        for (int i = row-1,j = cel-1; i >=0&&j>=0; i--,j--) {
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        //右上方
        for (int i = row-1,j = cel+1; i >=0&&j<board.length; i--,j++) {
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueensSolution solution = new NQueensSolution();
        List<List<String>> res = solution.solveNQueens(4);
        System.out.println(res.toString());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
