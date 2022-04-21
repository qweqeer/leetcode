package leetcode.editor.cn;//给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
//
// 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。 
//
// 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
//
// 注意：不允许旋转信封。 
// 
//
// 示例 1： 
//
// 
//输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出：3
//解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。 
//
// 示例 2： 
//
// 
//输入：envelopes = [[1,1],[1,1],[1,1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= envelopes.length <= 105 
// envelopes[i].length == 2 
// 1 <= wi, hi <= 105 
// 
// Related Topics 数组 二分查找 动态规划 排序 
// 👍 705 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class MaxEnvelopesSolution {

    /**
     *
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {
        int[]  dp = new int[envelopes.length];

        /**
         * 时间复杂度 O(n*log n)
         */
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]){
                    return o1[0]-o2[0];
                }
                return o2[1]-o1[1];
            }
        });

        List<Integer> bucketMinValue = new ArrayList<>();
        for(int i=0;i<envelopes.length;i++){
            int width = envelopes[i][1];
            if(bucketMinValue.isEmpty()||bucketMinValue.get(bucketMinValue.size()-1)<envelopes[i][1]){
                bucketMinValue.add(width);
            }else{
                int index=searchUpdateBucketIndex(bucketMinValue,width);
                bucketMinValue.set(index,width);
            }
        }
        return bucketMinValue.size();
    }

    public int searchUpdateBucketIndex(List<Integer> bucketMinValue, int value){
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


}
//leetcode submit region end(Prohibit modification and deletion)
