import spock.lang.Specification

class LetterCombinationsInPhoneNumberSpock extends Specification {
    def underSpec = new LetterCombinationsInPhoneNumber()

    def "generate all combinations"() {
        when:
        def result = underSpec.letterCombinations(digits)

        then:
        result ==~ expected

        where:
        digits | expected
        "23"   | ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
        "2"    | ["a", "b", "c"]
        ""     | []
    }
}
