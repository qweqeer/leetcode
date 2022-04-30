package leetcode.editor.cn;//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
// Related Topics 数组 排序 👍 1451 👎 0

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class ArrayMergeSolution {
    public int[][] merge(int[][] intervals) {
        // 类似会议室，戳气球题目
        // 计算相互链接的区间,返回不重叠的区间
        List<int[]> res = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a1,a2)->a1[0]==a2[0]?a1[1]-a2[1]:a1[0]-a2[0]);
        for (int[] interval : intervals) {
            queue.add(interval);
        }
        int[] interval = queue.poll();
        while (!queue.isEmpty()){
            int[] cur=queue.poll();
            if(interval[1]>=cur[0]){
                interval[1] = Math.max(interval[1],cur[1]);
            }else{
                res.add(interval);
                interval = cur;
            }
            if(queue.isEmpty()){
                res.add(interval);
            }
        }

        int[][] result = new int[res.size()][2];
        for (int i=0;i<res.size();i++){
            result[i] = res.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,5},{6,7},{6,8},{15,18}};
        ArrayMergeSolution solution = new ArrayMergeSolution();
        int[][] res = solution.merge(intervals);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
