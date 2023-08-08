import spock.lang.Specification

class WordBreakTest extends Specification {
    def "word break returns if the input text is covered in dictionary"() {
        def underSpec = new WordBreak();

        when:
        def result = underSpec.wordBreakRecursive(word, dictionary)

        then:
        result == expected

        where:
        dictionary                            | word            || expected
        ["leet", "code"]                      | "leetcode"      || true
        ["apple", "pen"]                      | "applepenapple" || true
        ["cats", "dog", "sand", "and", "cat"] | "catsandog"     || false
        ["a", "abc", "b", "cd"]               | "abcd"          || true
    }
}
