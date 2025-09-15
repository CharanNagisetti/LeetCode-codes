class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words=text.split(" ");
        int n=words.length;
        int usableCount = 0;
        for (int i = 0; i < n; i++) {
            boolean hasBroken = false;
            for (char c : brokenLetters.toCharArray()) {
                if (words[i].indexOf(c) != -1) {
                    hasBroken = true;
                    break;
                }
            }
            if (!hasBroken) usableCount++;
        }
        return usableCount;
    }
}