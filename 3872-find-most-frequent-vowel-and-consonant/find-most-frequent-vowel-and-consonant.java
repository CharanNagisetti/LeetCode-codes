class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character, Integer> vowel=new HashMap<>();
        HashMap<Character, Integer> consonant = new HashMap<>();
        int n=s.length();
        for(char c: s.toCharArray()){
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                vowel.put(c,vowel.getOrDefault(c,0)+1);
            }else{
                consonant.put(c,consonant.getOrDefault(c,0)+1);
            }
        }
        int vowels=0;
        int consonants=0;
        for(int x: vowel.values()){
            if(x>vowels) vowels=x;
        }
        for(int x: consonant.values()){
            if(x>consonants) consonants=x;
        }
        return vowels+consonants;
    }
}