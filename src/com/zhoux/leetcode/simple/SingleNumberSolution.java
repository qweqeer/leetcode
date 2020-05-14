package com.zhoux.leetcode.simple;

public class SingleNumberSolution {
    /**
     * 寻找数组中只出现一次的数字
     * https://leetcode-cn.com/problems/single-number/
     * 解法
     * 1、Hash
     * 2、双重遍历
     * 3、异或：a^b^a=b^a^a=a^a^b=b,a^a=0,0^a=a
     *
     */

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = nums[i]^res;
        }
        return res;
    }
}
