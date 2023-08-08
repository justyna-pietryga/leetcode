import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 04-08-2023
 * <a href="https://leetcode.com/problems/word-break"/>
 */
public class WordBreak {
    public boolean wordBreakDynamicProgramming(String s, List<String> wordDict) {
        int inputLength = s.length();
        int longestDictionaryWord = wordDict.stream()
                .map(String::length)
                .max(Comparator.comparingInt(Integer::intValue))
                .orElse(0);

        boolean[] dp = new boolean[inputLength + 1];
        dp[0] = true;

        for (int i = 1; i <= inputLength; i++) {
            for (int j = i - 1; j >= Math.max(i - longestDictionaryWord, 0); j--) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[inputLength];
    }

    public boolean wordBreakRecursive(String s, List<String> wordDict) {
        Set<String> wordsSet = new HashSet<>(wordDict);
        Map<String, Boolean> memo = new HashMap<>();
        return rec(s, wordsSet, memo);
    }

    private boolean rec(String s, Set<String> wordsSet, Map<String, Boolean> memo) {
        if (wordsSet.contains(s)) return true;
        if (memo.containsKey(s)) return memo.get(s);
        for (int i = 1; i < s.length(); i++) {
            String segmentedWord = s.substring(0, i);
            if (wordsSet.contains(segmentedWord) && rec(s.substring(i), wordsSet, memo)) {
                memo.put(segmentedWord, true);
                return true;
            }
        }
        memo.put(s, false);
        return false;
    }
}
