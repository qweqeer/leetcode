package com.zhoux.leetcode.mid;

public class SingleNumberArraySolution {
    /**
     * 计算数组中出现一次的数字(其他数字都出现3次)
     * https://leetcode-cn.com/problems/single-number-iii/
     * 解法：当一个数出现三次的时候抵消结果为0
     * 有限状态机
     * 第一次出现时使用a_bit保存结果，b_bit归零
     * 第二次出现时使用b_bit保存数字，a_bit归零
     * 第三次出现时使用a_bit与b_bit均归零
     */

    public static int[] singleNumber(int[] nums) {

        return null;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,3,2}));
    }

}
