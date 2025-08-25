class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        TreeMap<Integer, ArrayList<Integer>> map=new TreeMap<>();
        int m=mat.length;
        int n=mat[0].length; 
        int[] ans=new int[m*n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                map.putIfAbsent(i + j, new ArrayList<>());
                map.get(i + j).add(mat[i][j]);
            }
        }
        int c = 0;
        for (int d : map.keySet()) {
            List<Integer> l = map.get(d);

            if (d % 2 == 0) { 
                for (int i = l.size() - 1; i >= 0; i--) {
                    ans[c++] = l.get(i);
                }
            } else {
                for (int val : l) {
                    ans[c++] = val;
                }
            }
        }
        return ans;
    }
}