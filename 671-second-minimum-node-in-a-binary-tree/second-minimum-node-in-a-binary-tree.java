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
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        TreeSet<Integer> s=new TreeSet<>();
        inorder(root,s);
        int ans=-1;
        int size=s.size();
        if(size<2) return -1;
        s.pollFirst();
        return s.first();
    }
    void inorder(TreeNode root, TreeSet<Integer> s){
        if(root==null) return;
        inorder(root.left,s);
        s.add(root.val);
        inorder(root.right,s);
    }
}