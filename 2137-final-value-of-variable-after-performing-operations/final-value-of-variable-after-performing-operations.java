class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int ans=0;
        for(String s: operations){
            int i=0;
            if(s.charAt(i)=='X') i++;
            if(s.charAt(i)=='-') ans--;
            else ans++;
        }
        return ans;
    }
}