import java.util.*;

class Solution {
    public String[] spellchecker(String[] wordList, String[] queries) {
        Set<String> exact = new HashSet<>(Arrays.asList(wordList));
        Map<String, String> lowerMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();
        for (String word : wordList) {
            String lower = word.toLowerCase();
            String devowel = deVowel(lower);
            lowerMap.putIfAbsent(lower, word);
            vowelMap.putIfAbsent(devowel, word);
        }

        String[] ans = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exact.contains(q)) {
                ans[i] = q;
                continue;
            }

            String lowerQ = q.toLowerCase();
            String devowelQ = deVowel(lowerQ);

            if (lowerMap.containsKey(lowerQ)) {
                ans[i] = lowerMap.get(lowerQ);
            } else if (vowelMap.containsKey(devowelQ)) {
                ans[i] = vowelMap.get(devowelQ);
            } else {
                ans[i] = "";
            }
        }
        return ans;
    }

    private String deVowel(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
