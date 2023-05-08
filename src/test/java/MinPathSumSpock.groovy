import spock.lang.Specification

class MinPathSumSpock extends Specification {
    def "convert grid to list of nodes with neighbours"() {
        when:
        def underSpec = new MinPathSum()
        def result = underSpec.minPathSum(grid as int[][])

        then:
        result == expected

        where:
        grid                              || expected
        [[1, 3, 1], [1, 5, 1], [4, 2, 1]] || 7
    }
}
