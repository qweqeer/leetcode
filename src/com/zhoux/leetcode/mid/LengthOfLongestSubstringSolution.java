package com.zhoux.leetcode.mid;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstringSolution {
    /**
     * 无重复的最长字符串
     * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
     */

    public static int lengthOfLongestSubstring(String s) {
        if(null == s){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        int[] ph = new int[s.length()+1];
        char[] cArray = s.toCharArray();
        int max = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 1; i <= cArray.length; i++) {
            if(i-1!=0){
                for (int j = i-1; j >=0; j--) {
                    if(!set.contains(cArray[j])){
                        set.add(cArray[j]);
                        ph[i] = ph[i]+1;
                    }else{
                        break;
                    }
                }
            }else {
                ph[i]=1;
            }
            set.clear();
            max = Math.max(max,ph[i]);
        }
        return max;
    }

    /**
     * 利用左右指针，移动，保存指针区间内无重复的字符
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        if(null == s){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        int max = 0;
        int rPoint = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i <= s.length(); i++) {
            //左指针右移后，将前一个字符去掉
            if(i!=0){
                set.remove(s.charAt(i-1));
            }
            while (rPoint<s.length()&&!set.contains(s.charAt(rPoint))){
                set.add(s.charAt(rPoint));
                rPoint++;
            }
            max = Math.max(max,set.size());

        }
        return max;
    }

    public static void main(String[] args) {
        String str="abs23123425";
        System.out.println(lengthOfLongestSubstring2(str));
    }
}
