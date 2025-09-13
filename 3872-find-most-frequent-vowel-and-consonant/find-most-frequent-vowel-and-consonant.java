class Solution {
    public int maxFreqSum(String s) {
        int[] letters=new int[26];
        int n=s.length();
        for(char c: s.toCharArray()){
            letters[c-'a']+=1;
        }
        int vowels=0;
        int consonants=0;
        for(int i=0;i<26;i++){
            if(i==0 || i==4 || i==8 || i==14 ||i==20){
                if(letters[i]>vowels){
                    vowels=letters[i];
                }
            }else{
                if(letters[i]>consonants){
                    consonants=letters[i];
                }
            }
        }
        return vowels+consonants;
    }
}