package leetcode.editor.cn;//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 
//输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 数组 动态规划 👍 2105 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class RobHomeGetMoneySolution {
    int[][] dp_table;
    public int rob(int[] nums) {
        /**
         * 回溯法处理
         * 变化值: 几号房间、进不进
         *
         */
        dp_table = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            if(i==0){
                dp_table[i][0] = 0;
                dp_table[i][1] = nums[i];
                continue;
            }
            dp_table[i][0] = Math.max(dp_table[i-1][0],dp_table[i-1][1]);
            dp_table[i][1] = Math.max(dp_table[i-1][0]+nums[i],dp_table[i-1][1]);
        }
        return dp_table[nums.length-1][1];
    }


}
//leetcode submit region end(Prohibit modification and deletion)
