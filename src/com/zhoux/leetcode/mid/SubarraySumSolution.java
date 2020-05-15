package com.zhoux.leetcode.mid;

import java.util.HashMap;

public class SubarraySumSolution {

    /**
     * 和为K的数组
     * https://leetcode-cn.com/problems/subarray-sum-equals-k/
     */

    public static int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int count=0;
        for (int i = 0; i < len; i++) {
            int tmp = 0;
            for (int j = i; j < len; j++) {
                tmp+=nums[j];
                if (tmp==k){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 前缀+Hash
     * 1、第i个数+前i-1个数等于k
     * 2、保存前i个数之和在map中
     * 3、只要前i-1个数的和存在集合中则新增该值出现的次数
     */
    public static int subarraySumV2(int[] nums, int k) {

        int count=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        //元素等于k的情况
        map.put(0,1);
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre +=nums[i];
            if(map.containsKey(pre-k)){
                count+=map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySumV2(new int[]{0,1,1,-1,3,14,-12,10,0,0},2));
    }
}
