package com.zhoux.leetcode.mid;

import java.math.BigDecimal;

public class MincostTicketsSolution {

    /**
     * https://leetcode-cn.com/problems/minimum-cost-for-tickets/comments/
     * 最低票价
     */

    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length, maxDay = days[len - 1], minDay = days[0];
        int[] dp = new int[maxDay + 31]; // 这里+31的原因是票的最大有效期是30
        // 只需看 maxDay -> minDay，此区间外都不需要出门，不会增加费用
        for (int d = maxDay, i = len - 1; d >= minDay; d--) {
            // i 表示 days 的索引
            // 也可提前将所有 days 放入 Set，再通过 set.contains() 判断
            if (d == days[i]) {
                //dp数组中保存累计消耗的金额，每次判断当天出行在各票价有效期的产生的最小费用
                dp[d] = Math.min(dp[d + 1] + costs[0], dp[d + 7] + costs[1]);
                dp[d] = Math.min(dp[d], dp[d + 30] + costs[2]);
                i--; // 别忘了递减一天
            } else dp[d] = dp[d + 1]; // 不需要出门
        }
        return dp[minDay]; // 从后向前遍历，返回最前的 minDay
    }

    public static void main(String[] args) {
        MincostTicketsSolution solution = new MincostTicketsSolution();
        int[] days= {1,4,6,7,8,12,16,20};
        int[] costs = {2,7,13};
        int value = solution.mincostTickets(days, costs);
    }
}
