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
        Set<Character> vowels=Set.of('a','e','i','o','u');
        int count=0;
        for(char c: s.toCharArray()){
            if(vowels.contains(c)){
                count++;
            }
        }
        return count;
    }
}
