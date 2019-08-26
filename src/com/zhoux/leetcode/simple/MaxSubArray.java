package com.zhoux.leetcode.simple;

/**
 * @author:zhouxiang
 * @date:2019-08-21
 * @describe:
 * @status:
 */
public class MaxSubArray {

    /**
     * https://leetcode-cn.com/problems/maximum-subarray/
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     */

    public static void main(String[] args) {
        MaxSubArray obj = new MaxSubArray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(obj.solution(nums));
    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int solution(int[] nums){
        int sum = 0;
        int cache = nums[0];
        for (int num : nums) {
            if(sum>0){
                sum+=num;
            }else{
                sum = num;
            }
            cache = sum>cache?sum:cache;
        }
        return cache;
    }



}
