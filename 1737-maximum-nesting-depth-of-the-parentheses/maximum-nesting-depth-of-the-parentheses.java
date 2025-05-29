class Solution {
    public int maxDepth(String s) {
        int count=0;
        int maxCount=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                count++;
                if(count>=maxCount){
                    maxCount=count;
                }
            }else if(c==')'){
                count--;
            }
        }
        return maxCount;
    }
}