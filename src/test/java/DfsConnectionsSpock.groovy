import spock.lang.Specification

class DfsConnectionsSpock extends Specification {
    def "dfs connections"() {
        when:
        def underSpec = new DfsConnections();
        def result = underSpec.makeConnected(n, connections as int[][])

        then:
        result == expected

        where:
        n | connections                              || expected
        4 | [[0, 1], [0, 2], [1, 2]]                 || 1
        6 | [[0, 1], [0, 2], [0, 3], [1, 2], [1, 3]] || 2
        6 | [[0, 1], [0, 2], [0, 3], [1, 2]]         || -1
    }
}
