import spock.lang.Specification

class UnreachablePairsSpock extends Specification {
    def "dfs connections"() {
        when:
        def underSpec = new UnreachablePairs();
        def result = underSpec.countPairs(n, edges as int[][])

        then:
        result == expected

        where:
        n | edges                                    || expected
        7 | [[0, 2], [0, 5], [2, 4], [1, 6], [5, 4]] || 14
        3 | [[0, 1], [0, 2], [1, 2]]                 || 0
        4 | []                                       || 6
    }
}
