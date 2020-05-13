package com.zhoux.leetcode.mid;

public class MaxAreaSolution {

    /**
     * 盛最多水的容器
     * https://leetcode-cn.com/problems/container-with-most-water/
     * 两个下标的值组成的最大正方形 (i1-i2)*Min(V1,V2)
     */

    public static int maxArea(int[] height) {
        /**
         * 采用左右指针
         * 每次移动值较小的指针
         * 1、下标距离可能导致下一次的值变大或变下
         * 2、如果下一次值大于之前小的值，可以能导致总的值变大
         */
        if(null == height||height.length==1){
            return 0;
        }
        int leftPoint = 0,rightPoint = height.length-1;
        int width = rightPoint-leftPoint;
        Long area = 0L;
        while (leftPoint<rightPoint){
            area = Math.max(area,Math.min(height[leftPoint],height[rightPoint])*width);
            if(height[leftPoint]>height[rightPoint]){
                rightPoint--;
            }else
                leftPoint++;
            width--;
        }
        return area>Integer.MAX_VALUE?Integer.MAX_VALUE: area.intValue();

    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
