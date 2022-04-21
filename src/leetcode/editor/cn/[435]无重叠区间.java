package leetcode.editor.cn;//给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重
//叠 。 
//
// 
//
// 示例 1: 
//
// 
//输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
//输出: 1
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
// 
//
// 示例 2: 
//
// 
//输入: intervals = [ [1,2], [1,2], [1,2] ]
//输出: 2
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
// 
//
// 示例 3: 
//
// 
//输入: intervals = [ [1,2], [2,3] ]
//输出: 0
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= intervals.length <= 105 
// intervals[i].length == 2 
// -5 * 104 <= starti < endi <= 5 * 104 
// 
// Related Topics 贪心 数组 动态规划 排序 
// 👍 667 👎 0


import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class EraseOverlapIntervalsSolution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 保证剩下区间最长，每次选最早结束的区间,需要考虑整数溢出的问题
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)->Integer.compare(a[1],b[1]));
        for(int[] row : intervals){
            queue.add(row);
        }
        //由于intervals不为空，所以默认有一个不重叠子区间
        int ans = 1;
        //取最早结束的子区间
        int[] start_interval = queue.poll();
        while(!queue.isEmpty()){
            int[] next = queue.poll();
            //当前节点与最早结束子区间不相交，不重叠区间数+1，替换最早不重叠子区间为当前区间
            if(start_interval[1]<=next[0]){
                ans++;
                start_interval = next;
            }
        }
        //返回需要移除的子区间数
        return intervals.length -ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
