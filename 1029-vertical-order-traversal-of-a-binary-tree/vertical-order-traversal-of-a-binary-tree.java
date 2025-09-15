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
 class Node{
    TreeNode node;
    int hd;
    int row;
    public Node(TreeNode node, int hd, int row){
        this.node=node;
        this.hd=hd;
        this.row=row;
    }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        Map<Integer, PriorityQueue<Node>> map=new TreeMap<>();
        findHD(root,map, 0, 0);
        for(int x: map.keySet()){
            int size=map.get(x).size();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<size;i++){
                list.add(map.get(x).poll().node.val);
            }
            ans.add(list);
        }
        return ans;
    }
    public void findHD(TreeNode root, Map<Integer, PriorityQueue<Node>> map, int hd, int row) {
    if (root == null) return;
    Node curr = new Node(root, hd, row);
    map.computeIfAbsent(hd, k -> new PriorityQueue<>((a, b) -> {
        if (a.row != b.row) return a.row - b.row;
        return a.node.val - b.node.val;
    })).add(curr);
        if(root.left!=null) findHD(root.left, map,hd-1, row+1);
        if(root.right!=null) findHD(root.right,map,hd+1, row+1);
    }
}