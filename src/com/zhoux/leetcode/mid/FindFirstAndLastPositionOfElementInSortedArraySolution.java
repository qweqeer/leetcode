package com.zhoux.leetcode.mid;

/**
 * @author:treey
 * @create:2020/7/13
 **/
public class FindFirstAndLastPositionOfElementInSortedArraySolution {

    /**
     * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
     * 在排序数组中查找元素的第一个和最后一个位置
     * 时间复杂度 O(log n)
     */

    public int[] searchRange(int[] nums, int target) {
        if(null==nums||nums.length==0){
            return new int[]{-1,-1};
        }
        int startOffSet = findFirst(nums,target);
        int endOffSet = findLast(nums,target);
        return new int[]{startOffSet,endOffSet};
    }

    private int findFirst(int[] array,int target){
        int start = 0,end = array.length-1;
        while (start<=end){
            int mid = (start+end)/2;
            if(array[mid]==target&&((mid>start && array[mid-1]<target)||mid==start)){
                return mid;
            }else if (array[mid]<target){
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return -1;
    }
    private int findLast(int[] array,int target){
        int start = 0,end = array.length-1;
        while (start<=end){
            int mid = (start+end)/2;
            if(array[mid]==target&&((mid<end && array[mid+1]>target)||mid==end)){
                return mid;
            }else if (array[mid]<=target){
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArraySolution solution = new FindFirstAndLastPositionOfElementInSortedArraySolution();
        int[] result = solution.searchRange(new int[]{6,6,6,6,6,6}, 6);
        System.out.println("test done");
    }

}
