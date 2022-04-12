package leetcode.editor.cn;//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 广度优先搜索 数组 动态规划 
// 👍 1871 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class CoinChangeSolution {
    HashMap<Integer,Integer> amountCoinNum;
    public int coinChange(int[] coins, int amount) {
        amountCoinNum = new HashMap<>();
        return dp(coins,amount);
    }

    private int dp(int[] coins,int amount){
        //dp(amount) = 1 + dp(amount-coin)
        if(amount == 0) return 0;
        if(amount<0) return -1;
        if(amountCoinNum.containsKey(amount)){
            return amountCoinNum.get(amount);
        }
        int min = Integer.MAX_VALUE;
        for(int coin:coins){
            int subNum=dp(coins,amount-coin);
            if(subNum<0){
                continue;
            }
            min = Math.min(1+ subNum,min);
        }
        boolean hasMin = Integer.MAX_VALUE!=min;
        amountCoinNum.put(amount,hasMin?min:-1);
        return amountCoinNum.get(amount);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
