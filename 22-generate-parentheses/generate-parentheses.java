class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        int start=0;
        int close=0;
        generate(ans,"",start,close,n);
        return ans;
    }
    public void generate(List<String> ans, String str, int open, int close, int n){
        if(str.length()==2*n){
            ans.add(str);
            return;
        }
        //Add '(' if we still can add
        if(open<n){
            generate(ans,str+"(",open+1,close,n);
        }
        if(close<open){
            generate(ans,str+")",open,close+1,n);
        }
    }
}