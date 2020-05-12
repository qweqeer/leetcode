package com.zhoux.leetcode.mid;

public class MyAtoiSolution {
    /**
     * 将字符串转为整数
     * https://leetcode-cn.com/problems/string-to-integer-atoi/
     * 1、整数的长度，考虑越界的问题，使用long保存整数
     * 2、限制截取的长度
     */

    public static int myAtoi(String str) {
        if(null==str)
            return 0;
        str=str.trim();
        int symbol = 1;
        if(str.startsWith("-")){
            str=str.substring(1);
            symbol=-1;
        }else if(str.startsWith("+")){
            str=str.substring(1);
        }

        if(str.length()==0){
            return 0;
        }
        int offSet = -1;
        int start = 0;
        int res = -1;
        for (int i = 0; i < str.length()&&offSet-start<12; i++) {
            Character c = str.charAt(i);
            if(!Character.isDigit(c)){
                break;
            }
            if(c.equals('0')&&offSet+1==start){
                start++;
            }
            offSet=i;
        }
        if(offSet<0){
            return 0;
        }
        Long value = Long.valueOf(str.substring(0, offSet + 1)) * symbol;
        if(symbol<0 && value<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        if(symbol>0 && value>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return value.intValue();
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("20000000000000000000"));
        System.out.println(myAtoi("  0000000000012345678"));
    }
}
