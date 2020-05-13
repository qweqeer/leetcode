package com.zhoux.leetcode.mid;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderSolution {
    /**
     * 二叉树的层序遍历
     * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
     * 按照层级从左到右遍历
     */

    public  List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(null ==root)
            return res;
        search(root,0,res);
        return res;
    }

    public void search(TreeNode node,int level,List<List<Integer>> res){
        if(res.size()<=level){
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        if(null!=node.left){
            search(node.left,level+1,res);
        }
        if(null!=node.right){
            search(node.right,level+1,res);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
//                        ,
//                        new TreeNode(6),
//                        new TreeNode(2,
//                                new TreeNode(7),
//                                new TreeNode(4))),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));
        LevelOrderSolution solution = new LevelOrderSolution();
        List<List<Integer>> list = solution.levelOrder(root);
    }
}
