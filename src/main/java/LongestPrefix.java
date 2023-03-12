/**
 * 12-03-2023
 * <a href="https://leetcode.com/problems/longest-common-prefix"/>
 */
public class LongestPrefix {
    //vertical algorithm (faster when there is limited number of words)
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        if (strs.length != 0) {
            int amountOfStr = strs.length;
            int letterIndex = 0;

            for (Character c : strs[0].toCharArray()) {
                for (int i = 1; i < amountOfStr; i++) {
                    String str = strs[i];
                    if (str.length() <= letterIndex || str.charAt(letterIndex) != c) {
                        return result.toString();
                    }
                }
                result.append(c);
                letterIndex++;
            }
        }

        return result.toString();
    }

    //faster when bigger amounts of words
    public String horizontalLongestCommonPrefix(String[] strs) {
        String result = "";
        int amountOfStrs = strs.length;
        if (amountOfStrs != 0) {
            result = strs[0];

            for (int i = 1; i < amountOfStrs; i++) {
                while (!strs[i].startsWith(result)) {
                    result = result.substring(0, result.length() - 1);
                }
            }
        }

        return result;
    }
}