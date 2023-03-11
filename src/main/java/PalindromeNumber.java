import java.util.ArrayList;
import java.util.List;

/**
 * 11-03-2023
 * <a href="https://leetcode.com/problems/palindrome-number/"/>
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        long reverseNum = 0, number = x;
        for (int numberOfDigits = (int) Math.log10(x), reverseCounter = 0; numberOfDigits >= 0 ; numberOfDigits--, reverseCounter++) {
            int power = (int) Math.pow(10, numberOfDigits);
            reverseNum += number / power * Math.pow(10, reverseCounter);
            System.out.println(reverseNum);
            number %= power;
        }

        System.out.println(reverseNum);
        return reverseNum == x;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0) return false;
        List<Integer> digits = getDigits(x);
        for (int left = 0, right = digits.size() - 1; left < right; left++, right--) {
            if (!digits.get(left).equals(digits.get(right))) {
                return false;
            }
        }

        return true;
    }

    private List<Integer> getDigits(int number) {
        List<Integer> digits = new ArrayList<>();
        for (int i = (int) Math.log10(number); i >= 0; i--) {
            int power = (int) Math.pow(10, i);
            digits.add(number / power);
            number %= power;
        }
        return digits;
    }
}
