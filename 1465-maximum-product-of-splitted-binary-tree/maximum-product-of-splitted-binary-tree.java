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
    List<Long> arr=new ArrayList<>();
    public long getSum(TreeNode root){
        if(root==null) return 0;
        long left=getSum(root.left);
        long right=getSum(root.right);
        long sum=root.val+left+right;
        arr.add(sum);
        return sum;
    }
    public int maxProduct(TreeNode root) {
        TreeNode temp=root;
        long mod = 1_000_000_007;
        long totalSum=getSum(root);
        long max=0;
        for(long x: arr){
            long rem=x*(totalSum-x);
            max=Math.max(max,rem);
        }
        return (int)(max%mod);
    }
}