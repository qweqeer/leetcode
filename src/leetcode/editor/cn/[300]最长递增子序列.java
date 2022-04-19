package leetcode.editor.cn;//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//
// 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子
//序列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -104 <= nums[i] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 数组 二分查找 动态规划 
// 👍 2412 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class LengthOfLISV2Solution {

    public int lengthOfLISV2(int[] nums) {
        List<Stack<Integer>> heapStack = new ArrayList<>();
        for (int num : nums) {
            //考虑桶不存在的情况
            if(heapStack.isEmpty()){
                heapStack.add(new Stack<>());
                heapStack.get(0).push(num);
                continue;
            }else{
                /**
                 * n号桶一定存在比n-1号桶大的元素,且元素下标
                 */
                Stack<Integer> target = null;
                for (int i = 0; i < heapStack.size(); i++) {
                    if(heapStack.get(i).peek()>=num){
                        target = heapStack.get(i);
                        break;
                    }
                }
                if(target == null){
                    target = new Stack<>();
                    heapStack.add(target);
                }
                target.push(num);
            }
        }
        return heapStack.size();
    }

    public int lengthOfLISV3(int[] nums) {
        int[] bucketMinValue = new int[nums.length+1];
        Arrays.fill(bucketMinValue,100000);
        int valueLen = 0;
        for (int num : nums) {

            //考虑桶不存在的情况
            for (int i = 0; i <=valueLen ; i++) {
                if(num<=bucketMinValue[i]){
                    if(bucketMinValue[i] == 100000){
                        valueLen++;
                    }
                    bucketMinValue[i]= num;
                    break;
                }
            }
        }
        return valueLen;
    }

    /**
     * 使用二分法优化选择桶的时间复杂度
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        List<Integer> bucketMinValue = new ArrayList<>();
        int valueLen = 0;
        for (int num : nums) {
            if(bucketMinValue.isEmpty()||bucketMinValue.get(bucketMinValue.size()-1)<num){
                bucketMinValue.add(num);
            }else{
                int index=searchUpdateBucketIndex(bucketMinValue,num);
                bucketMinValue.set(index,num);
            }
        }
        return bucketMinValue.size();
    }

    public int searchUpdateBucketIndex(List<Integer> bucketMinValue,int value){
        int start = 0,end = bucketMinValue.size()-1;
        while (start<end){
            int mid = start +(end-start)/2;
            if(bucketMinValue.get(mid)>=value){
                end = mid;
            }else {
                start = mid+1;

            }
        }
        return start;
    }

    /**
     * 返回最大值
     * @param nums
     * @param start
     * @param end
     * @return
     */

    public int lengthOfLISV4(int[] nums){
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,1);
        int res = 0;
        for(int i=0;i<nums.length;i++){
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
