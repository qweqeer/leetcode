package com.zhoux.leetcode.mid;

public class MyPowSolution {

    /**
     * 计算x的n次幂
     * https://leetcode-cn.com/problems/powx-n/
     */

    /**
     * 1、n为0时任何数都为1
     * 2、n为负数时转成正数产生的溢出问题
     */

    /**
     * 时间复杂度O(logn)
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x,int n){
        if(n==0){
            return 1;
        }
        long maxN = n;
        if(maxN<0){
            x =1/x;
            maxN= -maxN;
        }
        double res = 1.00;
        for (long i = maxN; i !=0 ; i/=2) {
            if(i%2!=0){
               res = res *x;
            }
            x*=x;
        }
        return n>0?res:1/res;
    }



    public static void main(String[] args) {
        System.out.println(myPow(2.000,0));
        System.out.println(myPow(2.000,1));
        System.out.println(myPow(2.000,2));
        System.out.println(myPow(2.000,-2));

    }
}
