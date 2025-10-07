class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(i, visited, isConnected);
                count++;
            }
        }
        return count;
    }

    public void dfs(int i, int[] vis, int[][] connect) {
        vis[i] = 1;
        for (int j = 0; j < connect.length; j++) {
            if (connect[i][j] == 1 && vis[j] == 0) {
                dfs(j, vis, connect);
            }
        }
    }
}
