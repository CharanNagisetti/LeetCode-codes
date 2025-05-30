class Solution {
    public boolean checkValidString(String s) {
        int min=0;
        int max=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                min++;
                max++;
            }
            if(c==')'){
                min--;
                max--;
            }
            if(c=='*'){
                max++;
                min--;
            }
            if(max<0) return false;
            min=Math.max(0,min);
        }
        if(min==0 || max==0) return true;
        return false;
    }
}