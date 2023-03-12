import spock.lang.Specification

class LongestPrefixSpec extends Specification {
    def underSpec = new LongestPrefix()

    def "find longest prefix"() {
        when:
        def result = underSpec.horizontalLongestCommonPrefix(input as String[])

        then:
        result == expected

        where:
        input                              || expected
        ["flower", "flow", "flight"]       || "fl"
        ["flower", "flowers", "flowering"] || "flower"
        ["dog", "racecar", "car"]          || ""
        ["game", "g", "ga"]                || "g"
        []                                 || ""
        ["", "g", "game"]                  || ""
        ["g", "", "game"]                  || ""
        ["c", "acc", "ccc"]                || ""
        ["c", "acc"]                       || ""
    }
}
