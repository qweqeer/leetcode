//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。 
//
// 一般来说，删除节点可分为两个步骤： 
//
// 
// 首先找到需要删除的节点； 
// 如果找到了，删除它。 
// 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：root = [5,3,6,2,4,null,7], key = 3
//输出：[5,4,6,2,null,null,7]
//解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//
// 
//
// 示例 2: 
//
// 
//输入: root = [5,3,6,2,4,null,7], key = 0
//输出: [5,3,6,2,4,null,7]
//解释: 二叉树不包含值为 0 的节点
// 
//
// 示例 3: 
//
// 
//输入: root = [], key = 0
//输出: [] 
//
// 
//
// 提示: 
//
// 
// 节点数的范围 [0, 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// 节点值唯一 
// root 是合法的二叉搜索树 
// -10⁵ <= key <= 10⁵ 
// 
//
// 
//
// 进阶： 要求算法时间复杂度为 O(h)，h 为树的高度。 
// Related Topics 树 二叉搜索树 二叉树 👍 804 👎 0

package leetcode.editor.cn;

public class P450_DeleteNodeInABst {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P450_DeleteNodeInABst().new Solution();
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
        public TreeNode deleteNode(TreeNode root, int key) {
            /**
             * 1、找到目标节点，存在以下几种情况
             * * 目标节点为叶子节点，直接返回root即可
             * * 目标节点非叶子节点:取右子树最小的节点替换当前节点，取左子树最大的节点替换当前节点
             */
            if(null == root){
                return null;
            }
            if(root.val>key){
                root.left  =  deleteNode(root.left,key);
            }else if(root.val<key){
                root.right =  deleteNode(root.right,key);
            }else {
                if(root.left == null && root.right == null){
                    return null;
                }
                if(null == root.left){
                    return root.right;
                }
                TreeNode node = root.right;
                while (node.left!=null){
                    node = node.left;
                }
                node.left = root.left;
                root.right = deleteNode(root.right, node.val);
                node.right = root.right;
                return node;
            }
            return root;
        }
        boolean isFind = false;
        private TreeNode findKeyNode(TreeNode root,int key){
            if(root == null){
                return  null;
            }
            if(isFind){
                return  root;
            }
            if(root.val == key){
                if(root.left == null && root.right == null){
                    return  null;
                }else if (root.left!=null){
                    TreeNode leftMax = findMax(root.left);
                    if(leftMax.val == root.left.val){
                        leftMax.right = root.right;
                    }else{
                        leftMax.left = root.left;
                        leftMax.right = root.right;
                    }
                    return leftMax;
                }else{
                    TreeNode rightMin = findMin(root.right);
                    if(rightMin.val == root.right.val){
                        rightMin.left = root.left;
                    }else{
                        rightMin.right = root.right;
                        rightMin.left = root.left;
                    }
                    return rightMin;
                }
            }else if(root.val>key){
                root.left = findKeyNode(root.left,key);
            }else{
                root.right = findKeyNode(root.right,key);
            }
            return root;
        }

        private TreeNode findMax(TreeNode node){
            if(null == node){
                return null;
            }
            if(null == node.right){
                return node;
            }
            TreeNode max = findMax(node.right);
            if (max.val == node.right.val){
                node.right = null;
            }
            return max;
        }

        private TreeNode findMin(TreeNode node){
            if(null == node){
                return null;
            }
            if(null == node.left){
                return node;
            }
            TreeNode max = findMin(node.left);
            if (max.val == node.left.val){
                node.left = null;
            }
            return max;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
