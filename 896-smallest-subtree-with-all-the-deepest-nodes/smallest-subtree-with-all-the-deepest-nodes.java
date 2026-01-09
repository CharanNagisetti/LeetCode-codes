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
 class Dummy{
    TreeNode node;
    int val;
    public Dummy(TreeNode node, int val){
        this.node=node;
        this.val=val;
    }
 }
class Solution {
    public Dummy check(TreeNode root){
        if(root==null) return new Dummy(null,0);
        Dummy left=check(root.left);
        Dummy right=check(root.right);
        if(left.val>right.val) return new Dummy(left.node,left.val+1);
        else if(left.val<right.val) return new Dummy(right.node,right.val+1);
        else return new Dummy(root,left.val+1);
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Dummy ans=check(root);
        return ans.node;
    }
}