import java.util.LinkedList;
import java.util.List;

/**
 * 04-08-2023
 * <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number"/>
 */
public class LetterCombinationsInPhoneNumber {
    private final char[][] LETTERS_BY_NUMBER = new char[][]{
            {},
            {},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {
        List<String> results = new LinkedList<>();
        if (digits.length() > 0) {
            addLetter(new char[digits.length()], 0, digits, results);
        }
        return results;
    }

    private void addLetter(char[] text, int i, String digits, List<String> result) {
        if (i == digits.length()) {
            result.add(new String(text));
            return;
        }
        for (char letter : LETTERS_BY_NUMBER[digits.charAt(i) - '0']) {
            text[i] = letter;
            addLetter(text, i + 1, digits, result);
        }
    }
}
