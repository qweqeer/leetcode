package com.zhoux.leetcode.mid;

public class LowestCommonAncestorSolution {

    /**
     * 从二叉树中获取连个子节点的最大父节点
     * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
     */


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * 1、如果任意节点等于根节点，那么最近祖节点为根节点
         * 2、若果均不等，那么将左右节点作为根节点
         * 3、如果返回的左右节点均不为空，则说明当前节点为最近祖节点
         * 4、否则返回任意不为空节点，若均为空返回null
         */
        if(null == root){
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (null != left && null != right) {
            return root;
        }
        if (null != left) {
            return left;
        }
        if (null != right) {
            return right;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(5,
                        new TreeNode(6),
                        new TreeNode(2,
                                new TreeNode(7),
                                new TreeNode(4))),
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(8)));
        TreeNode node = lowestCommonAncestor(root, new TreeNode(6), new TreeNode(4));
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        this.val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}