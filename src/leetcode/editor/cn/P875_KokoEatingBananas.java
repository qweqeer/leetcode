//珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。 
//
// 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后
//这一小时内不会再吃更多的香蕉。 
//
// 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。 
//
// 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：piles = [3,6,7,11], h = 8
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：piles = [30,11,23,4,20], h = 5
//输出：30
// 
//
// 示例 3： 
//
// 
//输入：piles = [30,11,23,4,20], h = 6
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= piles.length <= 10⁴ 
// piles.length <= h <= 10⁹ 
// 1 <= piles[i] <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 373 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class P875_KokoEatingBananas {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P875_KokoEatingBananas().new Solution();
        int[] piles = new  int[]{30,11,23,4,Integer.MAX_VALUE};
        System.out.println(solution.minEatingSpeed(piles,8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            // 假设每小时吃K个香蕉，则每堆香蕉需要 1 至 X/K + 1 小时吃掉
            // 设定K的取值范围 转换为
            Arrays.sort(piles);
            for (int i = piles[0]; i <= piles[piles.length-1]; i++) {
                if(canEatAll(piles,i,h)){
                    return i;
                }
            }
            return -1;
        }

        private boolean canEatAll(int[] piles,int k,int h){
            int eatHours = 0;
            for (int i = 0; i < piles.length; i++) {
                eatHours += eatHours(piles[i],k);
                if(eatHours>h){
                    return false;
                }
            }
            return true;
        }


        private int eatHours(int nums,int k){
            return nums%k==0?nums/k:nums/k +1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
