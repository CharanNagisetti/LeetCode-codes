class Solution {
    public boolean doesAliceWin(String s) {
        int count=findVowels(s);
        if(count%2!=0){
            return true;
        }
        if(count==0){
            return false;
        }
        return true;
    }
    private int findVowels(String s){
        int count=0;
        for(char c: s.toCharArray()){
           if (check(c))count++;
        }
        return count;
    }
    private boolean check(char s){
        return "aeiouAEIOU".indexOf(s)>=0;
    }
}
