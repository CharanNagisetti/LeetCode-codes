class Solution {
    public String sortVowels(String s) {
        StringBuilder sb=new StringBuilder();
        List<Character> vowelCheck=new ArrayList<>();
        Set<Character> vowels=Set.of('a','e','i','o','u','A','E','I','O','U');
        int n=s.length();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(vowels.contains(c)){
                vowelCheck.add(c);
            }
        }
        Collections.sort(vowelCheck);
        int idx=0;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(vowels.contains(c)){
                sb.append(vowelCheck.get(idx));
                idx++;
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}