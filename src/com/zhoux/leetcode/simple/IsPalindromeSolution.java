package com.zhoux.leetcode.simple;

/**
 * @author:treey
 * @create:2020/5/19
 **/
public class IsPalindromeSolution {

    /**
     * 验证回文串
     * https://leetcode-cn.com/problems/valid-palindrome/
     * 只关注字母和数字，忽略其他字符和大小写
     */

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] chars = new char[s.length()];
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int cValue = (int)c;
            if((cValue>=65&&cValue<=90)||(cValue>=97&&cValue<=122)||Character.isDigit(c)){
                chars[len++] = c;
            }
        }
        int left = 0,right = len-1;
        while (left<right){
            if(chars[left++]!=chars[right--]){
                return false;
            }
        }
        return true;
    }
}
