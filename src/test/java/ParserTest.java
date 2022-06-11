import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {
    @Test
    public void fixedTests() {
//        assertEquals(1, Parser.parseInt("one"));
//        assertEquals(20, Parser.parseInt("twenty"));
//        assertEquals(246, Parser.parseInt("two hundred and forty-six"));
//        assertEquals(87596, Parser.parseInt("eighty-seven thousand five hundred ninety-six"));
        assertEquals(469825, Parser.parseInt2("four hundred and sixty-nine thousand eight hundred twenty-five"));
        String[] first = {"B", "D", "F", "G", "H", "J", "L", "Z", "Ż"};
        String[] second = {"Ą", "Ó", "U"};
        String[] third = {"B", "C", "D", "F", "J", "L"};

        for (String s : first) {
            for (String value : second) {
                for (String item : third) {
                    System.out.print(s + value + "Ż" + item + "E");
                    System.out.println();
                }
            }
        }
    }
}