import java.util.*;

class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<Integer, List<String>> memo = new HashMap<>();

        return solve(s, 0, dict, memo);
    }

    private List<String> solve(String s, int start,
                               Set<String> dict,
                               Map<Integer, List<String>> memo) {

        // Already calculated
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> result = new ArrayList<>();

        // Reached the end
        if (start == s.length()) {
            result.add("");
            return result;
        }

        // Try every possible word starting from 'start'
        for (int end = start + 1; end <= s.length(); end++) {

            String word = s.substring(start, end);

            if (!dict.contains(word)) {
                continue;
            }

            // Solve the remaining string
            List<String> remaining = solve(s, end, dict, memo);

            for (String sentence : remaining) {

                if (sentence.isEmpty()) {
                    result.add(word);
                } else {
                    result.add(word + " " + sentence);
                }
            }
        }

        memo.put(start, result);

        return result;
    }
}