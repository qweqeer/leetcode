package leetcode.editor.cn;//给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
//
// 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。 
//
// 在完成所有删除操作后，请你返回列表中剩余区间的数目。 
//
// 
//
// 示例： 
//
// 
//输入：intervals = [[1,4],[3,6],[2,8]]
//输出：2
//解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 1000 
// 0 <= intervals[i][0] < intervals[i][1] <= 10^5 
// 对于所有的 i != j：intervals[i] != intervals[j] 
// 
// Related Topics 数组 排序 👍 67 👎 0

import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class RemoveCoveredIntervalsSolution {
    public int removeCoveredIntervals(int[][] intervals) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->{
            return a[0]==b[0]?a[1]-b[1]:a[0]-b[0];
        });

        for (int[] interval : intervals) {
            queue.add(interval);
        }
        int res = intervals.length;
        int[] cur = queue.poll();
        while(!queue.isEmpty()){
            int[] next = queue.poll();
            if(cur[0]<=next[0] && cur[1]>=next[1]){
                res--;
            }else{
                cur = next;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        RemoveCoveredIntervalsSolution solution  = new RemoveCoveredIntervalsSolution();
        int[][] arrays = {{1,4},{3,6},{2,8}};
        solution.removeCoveredIntervals(arrays);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
