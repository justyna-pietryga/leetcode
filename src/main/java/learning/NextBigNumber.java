package learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class NextBigNumber {
    public static long nextBiggerNumber(long n){
        char [] s = String.valueOf(n).toCharArray();
        for(int i = s.length - 2; i >= 0; i--){
            for (int j = s.length-1; j > i; j--){
                if(s[i] < s[j]){
                    char tmp = s[i];
                    s[i] = s[j];
                    s[j] = tmp;
                    Arrays.sort(s, i+1, s.length);
                    return Long.parseLong(String.valueOf(s));
                }
            }
        }
        return -1;
    }

    public static long nextBiggerNumber2(long n) {
        String numberText = String.valueOf(n);
        int amountOfDigits = numberText.length();
        List<Integer> digits = new ArrayList<>();

        List<DigitDetail> remaining = new ArrayList<>();

        for (char digitChar : String.valueOf(n).toCharArray()) {
            digits.add(Character.getNumericValue(digitChar));
        }

        int i = amountOfDigits - 1;

        final AtomicInteger numberToChange = new AtomicInteger(-1);

        while (digits.get(i) <= digits.get(i - 1) && i > 1) {
            remaining.add(new DigitDetail(digits.get(i), i));
            i--;
        }

        if (i == 1 && digits.get(0) >= digits.get(i)) return -1;

        AtomicInteger index = new AtomicInteger(i + 1);
        System.out.println(remaining);
//        remaining = remaining.stream()
//                .sorted(Comparator.comparingInt(DigitDetail::getValue))
//                .map(remainDigit -> new DigitDetail(remainDigit.getValue(), index.getAndIncrement()))
//                .collect(Collectors.toList());

        final int potentialSwitchedDigit = digits.get(i);
        if (potentialSwitchedDigit >= digits.get(i - 1)) {
            remaining.add(new DigitDetail(potentialSwitchedDigit, i));
            numberToChange.set(digits.get(i - 1));
        }

        System.out.println(remaining);

        DigitDetail switchedDigit = remaining.stream()
                .filter(digit -> digit.getValue() > numberToChange.get() || (digit.getValue() == numberToChange.get() && digit.getValue() < potentialSwitchedDigit))
                .min(Comparator.comparingInt(DigitDetail::getValue)).orElse(DigitDetail.WRONG_DIGIT_DETAIL);

        System.out.println(switchedDigit.getValue() + " ," + switchedDigit.getPosition());
        if (switchedDigit.getValue() < digits.get(i)) {
            int temp = digits.get(i);
            digits.set(i, digits.get(switchedDigit.getPosition()));
            digits.set(switchedDigit.getPosition(), temp);
        }

        int temp = digits.get(i - 1);
        digits.set(i - 1, digits.get(i));
        digits.set(i, temp);

        return Long.parseLong(digits.toString().replaceAll("\\D", ""));
    }

    static class DigitDetail {
        private static final DigitDetail WRONG_DIGIT_DETAIL = new DigitDetail(-1, -1);
        int value;
        int position;

        public DigitDetail(int value, int position) {
            this.value = value;
            this.position = position;
        }

        public int getValue() {
            return value;
        }

        public int getPosition() {
            return position;
        }

        @Override
        public String toString() {
            return value + "";
        }
    }
}


//import java.util.ArrayList;
//        import java.util.Comparator;
//        import java.util.List;
//
//public class NextBigNumber {
//    public static long nextBiggerNumber(long n) {
//        System.out.println(n);
//        String numberText = String.valueOf(n);
//        int amountOfDigits = numberText.length();
//        ArrayList<Integer> digits = new ArrayList<>();
//
//        ArrayList<Integer> remaining = new ArrayList<>();
//
//        for (char digitChar : String.valueOf(n).toCharArray()) {
//            digits.add(Character.getNumericValue(digitChar));
//        }
//
//        int i = amountOfDigits - 2;
//
//        while (digits.get(i) >= digits.get(i + 1) && i >= 0) {
//            remaining.add(digits.get(i + 1));
//            i--;
//        }
//
//        int temp = digits.get(i);
//        digits.set(i, digits.get(i + 1));
//        digits.set(i + 1, temp);
//
//        remaining.sort(Comparator.comparingInt(Integer::intValue));
//
//        List<Integer> result = digits.subList(0, i + 2);
//        result.addAll(remaining);
//
//        return Long.parseLong(result.toString().replaceAll("\\D",""));
//    }
//}

//    public static long nextBiggerNumber(long n) {
//        System.out.println(n);
//        String numberText = String.valueOf(n);
//        int amountOfDigits = numberText.length();
//        ArrayList<Integer> digits = new ArrayList<>();
//
//        ArrayList<DigitDetail> remaining = new ArrayList<>();
//
//        for (char digitChar : String.valueOf(n).toCharArray()) {
//            digits.add(Character.getNumericValue(digitChar));
//        }
//
//        int i = amountOfDigits - 2;
//
//        final AtomicInteger numberToChange = new AtomicInteger(-1);
//
//        while (digits.get(i) >= digits.get(i + 1) && i >= 0) {
//            remaining.add(new DigitDetail(digits.get(i + 1), i + 1));
//            i--;
//        }
//
//        if (digits.get(i + 1) >= digits.get(i)) {
//            remaining.add(new DigitDetail(digits.get(i + 1), i + 1));
//            numberToChange.set(digits.get(i));
//        }
//
//        System.out.println("remaining: " + remaining);
//        DigitDetail switchedDigit = remaining.stream()
//                .filter(digit -> digit.getValue() > numberToChange.get())
//                .min(Comparator.comparingInt(DigitDetail::getValue)).orElse(DigitDetail.WRONG_DIGIT_DETAIL);
//
//
//        System.out.println("switchedDigit: " + switchedDigit.getValue());
//        if (switchedDigit.getValue() < digits.get(i + 1)) {
//            System.out.println("i'm here");
//            int temp = digits.get(i + 1);
//            digits.set(i + 1, digits.get(switchedDigit.getPosition()));
//            digits.set(switchedDigit.getPosition(), temp);
//        }
//
//        int temp = digits.get(i);
//        digits.set(i, digits.get(i + 1));
//        digits.set(i + 1, temp);
//
////        remaining.sort(Comparator.comparingInt(Integer::intValue));
//
////        List<Integer> result = digits.subList(0, i + 2);
////        result.addAll(remaining);
//
//        System.out.println(digits.toString());
//        return Long.parseLong(digits.toString().replaceAll("\\D", ""));
//    }
