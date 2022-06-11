import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 22-Jan-2022
 * https://www.codewars.com/kata/525c7c5ab6aecef16e0001a5/
 */
public class Parser {
    private static final Map<String, Integer> stringNumberMap = getStringNumberMap();

    public static int parseInt2(String numStr) {
        List<Integer> tmp = new LinkedList<>();

        tmp.add(Arrays.stream(numStr.replaceAll(" and", "").split(" "))
                .map(textNumber -> Arrays.stream(textNumber.split("-"))
                        .mapToInt(stringNumberMap::get)
                        .sum())
                .reduce(0, (a, b) -> {
                    if (a < b) {
                        if (a == 0) return b;
                        return a * b;
                    } else if (a > b && b > 0 && a / b < 100) return a + b;
                    else {
                        tmp.add(a);
                        return b;
                    }
                }));

        return tmp.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int parseInt(String numStr) {
        List<Integer> numbers = Arrays.stream(numStr.replaceAll(" and", "").split(" "))
                .map(textNumber -> Arrays.stream(textNumber.split("-"))
                        .mapToInt(stringNumberMap::get)
                        .sum())
                .collect(Collectors.toList());

        int max = numbers.size();
        int a = numbers.get(0);
        int b;
        List<Integer> tmp = new LinkedList<>();

        for (int i = 0; i < max; i++) {
            b = (max - 1 != i) ? numbers.get(i + 1) : 0;

            if (a < b) a *= b;
            else if (a > b && b > 0 && a / b < 100) a += b;
            else {
                tmp.add(a);
                a = b;
            }
        }

        tmp.add(a);

        return tmp.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static Map<String, Integer> getStringNumberMap() {
        var stringNumberMap = new HashMap<String, Integer>();

        stringNumberMap.put("zero", 0);
        stringNumberMap.put("one", 1);
        stringNumberMap.put("two", 2);
        stringNumberMap.put("three", 3);
        stringNumberMap.put("four", 4);
        stringNumberMap.put("five", 5);
        stringNumberMap.put("six", 6);
        stringNumberMap.put("seven", 7);
        stringNumberMap.put("eight", 8);
        stringNumberMap.put("nine", 9);
        stringNumberMap.put("ten", 10);
        stringNumberMap.put("eleven", 11);
        stringNumberMap.put("twelve", 12);
        stringNumberMap.put("thirteen", 13);
        stringNumberMap.put("fourteen", 14);
        stringNumberMap.put("fifteen", 15);
        stringNumberMap.put("sixteen", 16);
        stringNumberMap.put("seventeen", 17);
        stringNumberMap.put("eighteen", 18);
        stringNumberMap.put("nineteen", 19);
        stringNumberMap.put("twenty", 20);
        stringNumberMap.put("thirty", 30);
        stringNumberMap.put("forty", 40);
        stringNumberMap.put("fifty", 50);
        stringNumberMap.put("sixty", 60);
        stringNumberMap.put("seventy", 70);
        stringNumberMap.put("eighty", 80);
        stringNumberMap.put("ninety", 90);
        stringNumberMap.put("hundred", 100);
        stringNumberMap.put("thousand", 1000);
        stringNumberMap.put("million", 1000000);

        return stringNumberMap;
    }
}