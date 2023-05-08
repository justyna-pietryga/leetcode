import spock.lang.Specification

class ZeroFillSubarraySpec extends Specification {
    def underSpec = new ZeroFillSubarray()

    def "find longest prefix"() {
        when:
        def result = underSpec.zeroFilledSubarray(input as int[])

        then:
        result == expected

        where:
        input                    || expected
        [1, 3, 0, 0, 2, 0, 0, 4] || 6
        [0, 0, 0, 2, 0, 0]       || 9
        [2, 10, 2019]            || 0
    }
}
