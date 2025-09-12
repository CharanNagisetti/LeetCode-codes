class Solution {
    public boolean doesAliceWin(String s) {
        int count=findVowels(s);
        if(count%2!=0){
            return true;
        }
        if(count==0){
            return false;
        }
        boolean flag=true;
        char letters[]=s.toCharArray();
        int check=0;
        for(char c: letters){
            if(check==count-1){
                if(vowels(c)){
                    flag=false;
                    break;
                }
            }
            if(check==count){
                break;
            }
            if(vowels(c)){
                count++;
            }
        }
        return flag;
    }
    private int findVowels(String s){
        int count=0;
        for(char c: s.toCharArray()){
            if(vowels(c)) count++;
        }
        return count;
    }
    private boolean vowels(char c){
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
            return true;
        }
        return false;
    }
}
