package leetcode.editor.cn;//给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵
//树的后序遍历，重构并返回二叉树。 
//
// 如果存在多个答案，您可以返回其中 任何 一个。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
//输出：[1,2,3,4,5,6,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [1], postorder = [1]
//输出: [1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= preorder.length <= 30 
// 1 <= preorder[i] <= preorder.length 
// preorder 中所有值都 不同 
// postorder.length == preorder.length 
// 1 <= postorder[i] <= postorder.length 
// postorder 中所有值都 不同 
// 保证 preorder 和 postorder 是同一棵二叉树的前序遍历和后序遍历 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 232 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class SolutionConstruct {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return preAndPostBuild(preorder,0,preorder.length-1,postorder,0,postorder.length-1);
    }

    public static void main(String[] args) {
        SolutionConstruct construct = new SolutionConstruct();
        int[] preorder = new int[]{1,2,4,5,3,6,7};
        int[] postorder = new int[]{4,5,2,6,7,3,1};
        TreeNode node = construct.constructFromPrePost(preorder, postorder);
    }

    public TreeNode preAndInBuild(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd){
        if(preStart> preEnd){
            return null;
        }

        int rootVal = preorder[preStart];
        int index = 0;

        for(int i=0;i<=postEnd;i++){
            if(postorder[i]==rootVal){
                index = i;
                break;
            }
        }
        int leftSize = index - postStart;
        TreeNode rootNode=new TreeNode(rootVal);
        rootNode.left = preAndInBuild(preorder,preStart+1,preStart+leftSize,postorder,postStart,index-1);
        rootNode.right= preAndInBuild(preorder,preStart+leftSize+1,preEnd,postorder,index+1,postEnd);
        return rootNode;
    }

    private TreeNode preAndPostBuild(int[] preorder, int preStart, int preEnd,
                                     int[] postorder, int postStart, int postEnd){
        if(preStart>preEnd){
            return null;
        }
        if(preStart == preEnd){
            return new TreeNode(preorder[preStart]);
        }

        int rootValue = preorder[preStart];
        int leftRootValue = preorder[preStart+1];
        int index = 0;

        for(int i=0;i<=postEnd;i++){
            if(postorder[i]==leftRootValue){
                index = i;
                break;
            }
        }

        int leftSize = index-postStart+1;
        TreeNode root = new TreeNode(rootValue);
        root.left =preAndPostBuild(preorder,preStart+1,preStart+leftSize,postorder,postStart,index);
        root.right =preAndPostBuild(preorder,preStart+leftSize+1,preEnd,postorder,index+1,postEnd-1);

        LinkedList list = new LinkedList();
        return root;
    }


}

   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) { this.val = val;
          this.left = left;
          this.right = right;
          String str=":";
          StringBuilder sb  = new StringBuilder();
          sb.toString().split("");
         LinkedList list = new LinkedList();
     }

  }



//leetcode submit region end(Prohibit modification and deletion)
