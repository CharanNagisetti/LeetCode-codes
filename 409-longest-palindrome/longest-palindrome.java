class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> check=new HashMap<>();
        int n=s.length();
        if(n==1) return 1;
        for(int i=0;i<n;i++){
            check.put(s.charAt(i),check.getOrDefault(s.charAt(i),0)+1);
        }
        int ans=0;
        boolean odd=false;
        for(int i: check.values()){
            if(i%2==0){
                ans+=i;
            }else{
                ans+=i-1;
                odd=true;
            }
        }
        if(odd) return ans+1;
        else return ans;
    }
}