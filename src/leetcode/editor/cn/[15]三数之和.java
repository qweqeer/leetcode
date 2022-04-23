package leetcode.editor.cn;//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 排序 
// 👍 4683 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class ThreeSumSolution {
    HashSet<String> inSet = new HashSet<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0;i<=nums.length-3;i++){
            if(nums[i]>0){
                return res;
            }
            res.addAll(traverse(nums,i,nums[i]));
        }

        return res;
    }

    private List<List<Integer>> traverse(int[] nums,int offset,int value){
        if(nums.length-offset<3){
            return new ArrayList<>();
        }
        int left = offset+1,right = nums.length-1;
        List<List<Integer>> res = new ArrayList<>();
        while (left<right){
            if(nums[left]+nums[right]+value==0){
                if(!isContain(value,nums[left],nums[right])){
                    List<Integer> zuhe = new ArrayList<>();
                    zuhe.add(value);
                    zuhe.add(nums[left]);
                    zuhe.add(nums[right]);
                    res.add(zuhe);
                }
                left++;right--;
            }else if(nums[left]+nums[right]+value<0) {
                left++;
            }else if(nums[left]+nums[right]+value>0){
                right--;
            }
        }
        return res;
    }

    private boolean isContain(int a,int b,int c){
        String key = a+","+b+","+c;
        boolean hasInSet = inSet.contains(key);
        if(!hasInSet){
            inSet.add(key);
        }
        return hasInSet;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
