class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int sat_child=0;
        int i=0;
        int j=0;
        while(i<g.length && j<s.length){
            if(g[i]<=s[j]){
                sat_child+=1;
                i++;
            }
            j++;
        }
        return sat_child;
    }
}