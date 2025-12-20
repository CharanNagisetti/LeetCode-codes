class Solution {
    public int minDeletionSize(String[] strs) {
        int n=strs[0].length();
        int n1=strs.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n1-1;j++){
                if((strs[j+1].charAt(i))-(strs[j].charAt(i))>=0) continue;
                else{
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }
}