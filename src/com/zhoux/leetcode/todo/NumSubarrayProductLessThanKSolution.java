package com.zhoux.leetcode.todo;

/**
 * @author:treey
 * @create:2020/5/18
 **/
public class NumSubarrayProductLessThanKSolution {
    /**
     * 乘积小于K的子数组
     * https://leetcode-cn.com/problems/subarray-product-less-than-k/
     */

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(null==nums||nums.length==0){
            return 0;
        }
        if(nums.length==1 ){
            return nums[0]<k?1:0;
        }
        int tmpValue = 1;
        int lpoint = 0;
        int count=0;


        //TODO


        return 0;

    }
}
