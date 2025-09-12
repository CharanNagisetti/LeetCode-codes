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
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                count++;
            }
        }
        return count;
    }
}
