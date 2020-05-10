package com.zhoux.leetcode.hard;

public class FindMedianSortedArraysSolution {
    //TODO 待完成
    /**
     * 获取两个数组中的中位数
     * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
     */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /**
         * 1、找到两个数
         */
        int left = (nums1.length + nums2.length + 1) / 2;
        int right = (nums1.length + nums2.length + 2) / 2;
        int[] min = nums1.length > nums2.length ? nums2 : nums1;
        int[] max = nums1.length > nums2.length ? nums1 : nums2;
        return 0d;
    }

    public int findNum(int[] min, int[] max, int start, int end) {
        int minMid = min[min.length/2];

        return 0;

    }


}
