package com.zhoux.leetcode.mid;

public class SingleNumberArraySolution {
    /**
     * 计算数组中出现一次的数字(其他数字都出现3次)
     * https://leetcode-cn.com/problems/single-number-iii/
     *
     *
     */

    public static int[] singleNumber(int[] nums) {
        int def = 0;
        for (int num : nums) {
            def=def^num;
        }
        int leftPoint=0,rightPoint=0;
        //TODO 升入了解位运算的特点
        return null;
    }

    public static void main(String[] args) {
        System.out.println(5&-5);
    }

}
