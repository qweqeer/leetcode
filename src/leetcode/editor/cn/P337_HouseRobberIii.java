//小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。 
//
// 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接
//相连的房子在同一天晚上被打劫 ，房屋将自动报警。 
//
// 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [3,2,3,null,3,null,1]
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7 
//
// 示例 2: 
//
// 
//
// 
//输入: root = [3,4,5,1,3,null,1]
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
// 
//
// 
//
// 提示： 
//
// 
//
// 
// 树的节点数在 [1, 10⁴] 范围内 
// 0 <= Node.val <= 10⁴ 
// 
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1322 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

public class P337_HouseRobberIii {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P337_HouseRobberIii().new Solution();
        TreeNode root  = new TreeNode(3,new TreeNode(4,new TreeNode(1),new TreeNode(3)),new TreeNode(5,null,new TreeNode(1)));
        System.out.println(solution.rob(root));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        HashMap<TreeNode,Integer> dp_table_used = new HashMap<>();
        HashMap<TreeNode,Integer> dp_table = new HashMap<>();
        public int rob(TreeNode root) {
            /**
             * 动态规划
             * 状态: 选 、 不选
             * 规则翻译：
             * 左子树选了，右子树则不能选
             * 父节点选了则子节点不能被选
             * 备忘录:
             * 记录每个节点可获取的最大金额
             *
             */
            return Math.max(traverse(root,true),traverse(root,false));
        }

        private int traverse(TreeNode root,boolean canSelect){
            if(dp_table.containsKey(root)){
                if(canSelect){
                    return dp_table.get(root);
                }else{

                }
            }
            if(null == root){
                return 0;
            }
            int ans  = 0;
            //当前阶段可以选择
            if(canSelect){
                //选
                int selectVal=root.val +
                        traverse(root.left,false) +
                        traverse(root.right,false);
                ans = Math.max(selectVal,ans);
            }
            //不选
            int noSelectVal = traverse(root.left,true)+
                    traverse(root.right,true);
            ans = Math.max(noSelectVal,ans);

            dp_table.put(root,ans);
            return ans;

        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}
