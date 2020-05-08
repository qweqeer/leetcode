package com.zhoux.leetcode.simple;

public class MySqrtSolution {

    /**
     * x的根平方
     * https://leetcode-cn.com/problems/sqrtx/
     */

    public int mySqrt(int x) {
        Double value = Math.sqrt((double) x);
        return value.intValue();
    }

}
