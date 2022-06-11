/**
 14-Mar-2022
 https://www.codewars.com/kata/51b66044bce5799a7f000003/
 */

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class RomanNumerals {
    private static final Map<Integer, String> romanByNumeralMap = setUp();
    private static final Map<String, Integer> numeralByRomanMap = romanByNumeralMap.entrySet()
            .stream()
            .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

    public static String toRoman(int n) {
        return getRoman(n);
    }

    private static String getRoman(int number) {
        if (number >= 4000 || number < 1) return "";

        String textNumber = String.valueOf(number);
        int numOfTens = textNumber.length() - 1;
        int power = (int) Math.pow(10, numOfTens);
        int a = Character.getNumericValue(textNumber.charAt(0)) * power;
        int b = number - a;

        if (b == 0) {
            return romanByNumeralMap.computeIfAbsent(a, key -> {
                ClosestRoman closestRoman = List.of(new ClosestRoman(power, 1, a), new ClosestRoman(power, 5, a), new ClosestRoman(power, 10, a))
                        .stream()
                        .filter(clos -> clos.getAbsDiff() <= clos.getMaxDif())
                        .min(Comparator.comparingInt(ClosestRoman::getAbsDiff))
                        .get();

                if (!closestRoman.isNegative())
                    return getRoman(closestRoman.getNumber()) + getRoman(closestRoman.getAbsDiff());
                else return getRoman(closestRoman.getAbsDiff()) + getRoman(closestRoman.getNumber());

            });
        }

        return getRoman(a) + getRoman(b);
    }

    public static int fromRoman(String romanNumeral) {
        int size = romanNumeral.length();
        int result = 0;
        int i = 0;
        while (i < size) {
            String a = String.valueOf(romanNumeral.charAt(i));
            int aNum = numeralByRomanMap.get(a);
            int bNum = 0;
            if (i < size - 1) {
                bNum = numeralByRomanMap.get(String.valueOf(romanNumeral.charAt(i + 1)));
            }

            if (aNum < bNum) {
                result += (bNum - aNum);
                i += 2;
            } else if (bNum != 0 && aNum > bNum && aNum / bNum < 10) {
                result += aNum + bNum;
                i += 2;
            } else {
                result += aNum;
                i++;
            }
        }
        return result;
    }

    private static Map<Integer, String> setUp() {
        Map<Integer, String> romanNumeralMap = new ConcurrentHashMap<>();
        romanNumeralMap.put(1, "I");
        romanNumeralMap.put(5, "V");
        romanNumeralMap.put(10, "X");
        romanNumeralMap.put(50, "L");
        romanNumeralMap.put(100, "C");
        romanNumeralMap.put(500, "D");
        romanNumeralMap.put(1000, "M");

        return romanNumeralMap;
    }

    static class ClosestRoman {
        int number;
        int absDiff;
        boolean negative;
        int maxDif;

        public ClosestRoman(int power, int multiple, int base) {
            this.number = power * multiple;
            int difference = base - this.number;
            this.absDiff = Math.abs(difference);
            this.negative = difference < 0;
            this.maxDif = this.negative ? power : 3 * power;
        }

        public int getNumber() {
            return number;
        }

        public int getAbsDiff() {
            return absDiff;
        }

        public boolean isNegative() {
            return negative;
        }

        public int getMaxDif() {
            return maxDif;
        }
    }
}