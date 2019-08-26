package com.zhoux.leetcode.simple;

/**
 * @author:zhouxiang
 * @date:2019-08-21
 * @describe:
 * @status:
 */
public class MaxProduct {

    public static void main(String[] args) {
        int[] nums = {2,3,-2,-4};

        MaxProduct obj = new MaxProduct();
        System.out.println(obj.solutioin(nums));
    }

    public int solutioin(int[] nums) {
        int maxValue = nums[0];

        int minCache = 1;
        int maxCache = 1;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<0){
                int tmp = minCache;
                minCache = maxCache;
                maxCache = tmp;
            }
            maxCache  = Math.max(maxCache*nums[i],nums[i]);
            minCache = Math.min(minCache*nums[i],nums[i]);

            maxValue = Math.max(maxCache,maxValue);
        }
        return maxValue;
    }

}
