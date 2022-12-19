import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anagram {
    public BigInteger listPosition(String word) {
        int n = word.length();
        BigInteger result = BigInteger.ZERO;

        List<Character> wordLetters = word.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        List<Character> sortedLetters = new ArrayList<>(new TreeSet<>(wordLetters));
        Map<Character, Long> letterByOccurrences = wordLetters.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Character, Long> letterByOccurrencesBkp;

        for (int i = 0; i < n; i++) {
            char letter = word.charAt(i);
            int alphabeticIndex = sortedLetters.indexOf(letter);
            letterByOccurrencesBkp = cloneMap(letterByOccurrences);
            if (alphabeticIndex != 0) {
                for (int j = 0; j < alphabeticIndex; j++) {
                    Character oneOfPreviousLetter = sortedLetters.get(j);
                    subtractOrRemove(letterByOccurrences, Collections.emptyList(), oneOfPreviousLetter);
                    BigInteger amountOfWordsBeforeRequested = (factorial(BigInteger.valueOf(n - i - 1L))).divide(
                            (letterByOccurrences.values()
                                    .stream()
                                    .map(BigInteger::valueOf)
                                    .reduce(BigInteger.ONE, (res, val) -> res.multiply(factorial(val)))
                            )
                    );

                    result = result.add(new BigInteger(String.valueOf(amountOfWordsBeforeRequested)));
                    letterByOccurrences = cloneMap(letterByOccurrencesBkp);
                }
            }
            subtractOrRemove(letterByOccurrences, sortedLetters, letter);
        }

        return result.add(BigInteger.ONE);
    }

    public BigInteger listPosition2(String word) {
        int n = word.length();
        BigInteger result = BigInteger.ZERO;

        List<Integer> wordLetters = word.chars()
                .boxed()
                .collect(Collectors.toList());

//        List<Character> sortedLetters = new ArrayList<>(new TreeSet<>(wordLetters));
        AtomicReference<Map<Integer, Long>> letterByOccurrences = new AtomicReference<>(wordLetters.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
        AtomicReference<Map<Integer, Long>> letterByOccurrencesBkp = new AtomicReference<>();

        for (int i = 0; i < n; i++) {
            int letter = wordLetters.get(i);
            letterByOccurrencesBkp.set(letterByOccurrences.get());
            int finalI = i;
            result = wordLetters.stream()
                    .filter(val -> val < letter)
                    .peek(val -> subtractOrRemove(letterByOccurrences, val))
                    .map(val -> (factorial(BigInteger.valueOf(n - finalI - 1L))).divide(
                            (letterByOccurrences.get()
                                    .values()
                                    .stream()
                                    .map(BigInteger::valueOf)
                                    .reduce(BigInteger.ONE, (res, value) -> res.multiply(factorial(value)))
                            )
                    ))
                    .peek((val) -> letterByOccurrences.set(letterByOccurrencesBkp.get()))
                    .reduce(result, (a, b) -> a = a.add(b));
            subtractOrRemove(letterByOccurrences, letter);
        }

        return result.add(BigInteger.ONE);
    }

    private void subtractOrRemove(AtomicReference<Map<Integer, Long>> letterByOccurrences, Integer val) {
        Long occurrencesOfLetter = letterByOccurrences.get()
                .get(val);
        if (occurrencesOfLetter > 1) {
            letterByOccurrences.get()
                    .replace(val, occurrencesOfLetter - 1);
        }
    }

    private void subtractOrRemove(Map<Character, Long> occurrencesMap, List<Character> alphabeticOrder, Character letter) {
        Long occurrencesOfLetter = occurrencesMap.get(letter);
        if (occurrencesOfLetter == 1) {
            alphabeticOrder.remove(letter);
            occurrencesMap.remove(letter);
        } else if (occurrencesOfLetter > 1) {
            occurrencesMap.replace(letter, occurrencesOfLetter - 1);
        }
    }

    private Map<Character, Long> cloneMap(Map<Character, Long> map) {
        return map.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private BigInteger factorial(BigInteger n) {
        if (n.compareTo(BigInteger.TWO) <= 0) {
            return n;
        }
        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }
}