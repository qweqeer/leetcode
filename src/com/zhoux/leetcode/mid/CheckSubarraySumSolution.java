package com.zhoux.leetcode.mid;

import java.util.HashMap;

public class CheckSubarraySumSolution {
    /**
     * 连续的子数组和
     * https://leetcode-cn.com/problems/continuous-subarray-sum/
     */
    public static boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int rem = 0;
        for (int i = 0; i < nums.length; i++) {
            rem += nums[i];
            if(k!=0)
                rem = rem % k;
            if (map.containsKey(rem) && i - map.get(rem) > 1)
                return true;
            if(!map.containsKey(rem))
                map.put(rem, i);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{23, 2, 3, 6, 7}, 7));
    }

}
