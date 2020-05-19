package com.zhoux.leetcode.simple;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author:treey
 * @create:2020/5/19
 **/
public class ValidPalindromeSolution {
    /**
     * 验证回文字符串II
     * https://leetcode-cn.com/problems/valid-palindrome-ii/
     * 最多允许删除一个字符串
     */

    /**
     * 当出现不等时，缩小某一端指针时，如果两个子字符串不是回文则删除以为后原字符串不是回文
     * @param s
     * @return
     */
    public static boolean validPalindrome(String s) {
        if(s==null||s.length()<=1){
            return true;
        }
        int left = 0,right = s.length()-1;
        while (left<right ){
            if(s.charAt(left)!=s.charAt(right)){
                return isValid(s,left,right=1)||isValid(s,left+1,right);
            }
        }
        return true;
    }

    private static boolean isValid(String str,int left,int right) {
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("abc"));
    }

}
