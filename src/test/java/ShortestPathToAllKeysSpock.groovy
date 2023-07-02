import spock.lang.Specification
import spock.lang.Unroll

class ShortestPathToAllKeysSpock extends Specification {
    def underSpock = new ShortestPathToAllKeys()

    @Unroll
    def "find starting point and count keys"() {
        when:
        underSpock.setUp(n, m, input as String[])

        then:
        underSpock.startX == startX
        underSpock.startY == startY
        underSpock.keyMask == keyMask

        where:
        input                                | n | m | startX | startY | keyMask
        ["@.a..", "###.#", "b.A.B"]          | 3 | 5 | 0      | 0      | 3
        ["###.#", ".@a..", "b.A.B", "c##.C"] | 4 | 5 | 1      | 1      | 7
    }

    @Unroll
    def "compute moves when next move #msg"() {
        given:
        def grid = ["@.a..", "###.#", "b.A.B"] as String[]
        def currentCellState = new ShortestPathToAllKeys.CellState(0, 1, 0)
        when:
        def result = underSpock.computeMove(grid, 3, 5, currentCellState, move as int[], 0)

        then:
        result == expected

        where:
        move    || expected                                     | msg
        [0, -1] || new ShortestPathToAllKeys.CellState(0, 0, 0) | "is an empty cell"
        [0, 1]  || new ShortestPathToAllKeys.CellState(0, 2, 1) | "has new key"
        [-1, 0] || null                                         | "is beyond the edge"
        [1, 0]  || null                                         | "is a wall"
    }

    @Unroll
    def "find starting point and count keys 2"() {
        when:
        def result = underSpock.shortestPathAllKeys(grid as String[])

        then:
        result == expected
        where:
        grid                        | expected
        ["@.a..", "###.#", "b.A.B"] | 8
        ["@..aA", "..B#.", "....b"] | 6
    }
}
