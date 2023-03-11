import spock.lang.Specification
import spock.lang.Unroll

class PalindromeNumberTest extends Specification {
    def underSpec = new PalindromeNumber()

    @Unroll
    def "number #number #msg"() {
        when:
        def result = underSpec.isPalindrome(number)

        then:
        result == expected

        where:
        number     || expected | msg
        121        || true     | "is a palindrome"
        52         || false    | "is not a palindrome"
        10         || false    | "is not a palindrome"
        -121       || false    | "is a palindrome"
        2147483647 || false    | "is not a palindrome"
    }

    @Unroll
    def "get proper digits from #number number"() {
        when:
        def result = underSpec.getDigits(number)

        then:
        result == expected

        where:
        number | numberOfDigits || expected
        121    | 3              || [1, 2, 1]
        52     | 2              || [5, 2]
        1000   | 4              || [1, 0, 0, 0]
        55555  | 5              || [5, 5, 5, 5, 5]
    }
}
