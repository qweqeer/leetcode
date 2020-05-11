package com.zhoux.leetcode.mid;

public class StringConvertToZSolution {
    /**
     * Z字形变化
     * https://leetcode-cn.com/problems/zigzag-conversion/
     * 规则：从上到下，从左到右
     *                      L   C   I   R
     * LEETCODEISHIRING ===>E T O E S I I G  ===> LCIRETOESIIGEDHN
     *                      E   D   H   N
     */

    public static String convert(String s, int numRows) {
        /**
         * 模拟路径
         */
        if(numRows<=1){
            return s;
        }
        int len = s.length();
        int row = 0;
        boolean updown = false;
        String[] rowStr = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            rowStr[i]="";
        }
        for (int i = 0; i < len; i++) {
            rowStr[row] = rowStr[row]+s.charAt(i);
            if(row==0||row==numRows-1){
                updown = !updown;
            }
            row = updown?++row:--row;
        }
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < rowStr.length; i++) {
            tmp.append(rowStr[i]);
        }
        return tmp.toString();
    }

    public static String convertV2(String s, int numRows) {
        /**
         * 找元素规律
         *
         */
        if(numRows<=1){
            return s;
        }
        //TODO
        return "";
    }

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING",3));
    }
}
