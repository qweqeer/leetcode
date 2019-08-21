package com.zhoux.leetcode.simple;

/**
 * @author:zhouxiang
 * @date:2019-08-21
 * @describe:
 * @status:
 */
public class LengthOfLastWord {

    /**
     * https://leetcode-cn.com/problems/length-of-last-word/
     *
     * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
     *
     * 如果不存在最后一个单词，请返回 0 。
     */

    public static void main(String[] args) {

        LengthOfLastWord solutioin = new LengthOfLastWord();

        System.out.println(solutioin.solution("hello word !"));
    }

    public int solution(String wordStr){
        String[] words = wordStr.split(" ");

        nextWord:
        for (int i =  words.length-1; i >=0; i--) {
            char[] chars = words[i].toCharArray();
            for (char aChar : chars) {
                if(!checkChar(aChar)){
                   continue nextWord;
                }
            }
            return chars.length;
        }
        return 0;
    }

    private boolean checkChar(char a){
        if(a>='A' && a<='Z'  ||  a>='a' && a<='z'){
            return true;
        }
        return false;
    }



}
