package com.zhoux.leetcode.mid;

/**
 * @author:treey
 * @create:2020/5/18
 **/
public class MaxProductSolution {

    /**
     * 乘积最大的子数组
     * https://leetcode-cn.com/problems/maximum-product-subarray/
     */

    /**
     * 暴力求解
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        if(null==nums||nums.length==0){
            throw new RuntimeException();
        }
        int maxValue = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int tmpValue = nums[i];
            int j = i+1;
            maxValue = Math.max(tmpValue,maxValue);
            while (j<nums.length){
                tmpValue*=nums[j];
                maxValue = Math.max(tmpValue,maxValue);
                if(0==tmpValue){
                    break;
                }
                j++;

            }
        }
        return maxValue;
    }

    /**
     * 动态规划,空间换时间
     * 1、最大值和最小值的互换
     * 2、nums[i]为0时状态同时归零
     *
     */
    public static int maxProductV2(int[] nums) {
        if(null==nums||nums.length==0){
            return 0;
        }
        int len = nums.length;
        //保存最大值和最小值 0：最大值 1最小值
        int[][] dp = new int[2][len];
        dp[0][0] = nums[0];
        dp[1][0] = nums[0];
        int maxValue = dp[0][0];
        for (int i = 1; i < len; i++) {
            if(nums[i]>=0){
                dp[0][i] = Math.max(nums[i],nums[i]*dp[0][i-1]);
                dp[1][i] = Math.min(nums[i],nums[i]*dp[1][i-1]);
            }else{
                dp[0][i] = Math.max(nums[i],nums[i]*dp[1][i-1]);
                dp[1][i] = Math.min(nums[i],nums[i]*dp[0][i-1]);
            }
            maxValue=Math.max(maxValue,dp[0][i]);
        }
        return maxValue;
    }

    /**
     * 优化空间消耗
     * @param nums
     * @return
     */
    public static int maxProductV3(int[] nums) {
        if(null==nums||nums.length==0){
            return 0;
        }
        int len = nums.length;
        //保存最大值和最小值 0：最大值 1最小值
        /**
         * 由于每次只使用了前一次的值，则保存前一次的值即可
         */
        int preMaxValue = nums[0];
        int preMinValue = nums[0];
        int curMaxValue;
        int curMinValue;

        int maxValue = preMaxValue;
        for (int i = 1; i < len; i++) {
            if(nums[i]>=0){
                curMaxValue = Math.max(nums[i],nums[i]*preMaxValue);
                curMinValue = Math.min(nums[i],nums[i]*preMinValue);
            }else{
                curMaxValue = Math.max(nums[i],nums[i]*preMinValue);
                curMinValue = Math.min(nums[i],nums[i]*preMaxValue);
            }
            preMaxValue = curMaxValue;
            preMinValue = curMinValue;
            maxValue=Math.max(maxValue,curMaxValue);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        System.out.println(maxProductV2(new int[]{2,3,-2,4}));
    }
}
