class Solution {
    int maxDia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxDia;
    }
    private int height(TreeNode node) {
        if (node==null) return 0;
        int leftHeight=height(node.left);
        int rightHeight=height(node.right);
        maxDia=Math.max(maxDia ,leftHeight+rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}