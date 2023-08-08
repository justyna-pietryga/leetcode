import spock.lang.Specification

class Search2dMatrixSpec extends Specification {
    def "search 2D matrix if target exists"() {
        def underSpec = new Search2dMatrix()

        when:
        def result = underSpec.searchMatrix(matrix as int[][], target)

        then:
        result == expected

        where:
        matrix                                             | target || expected
        [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]] | 3      || true
        [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]] | 11     || true
        [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]] | 60     || true
        [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]] | 4      || false
        [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]] | 62     || false
        [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]] | 0      || false
        [[1]]                                              | 0      || false
    }

//    def "rec1"() {
//        def underSpec = new Search2dMatrix()
//
//        when:
//        def result = underSpec.is(matrix as int[], i, j, target)
//
//        then:
//        result == expected
//
//        where:
//        matrix      | i | j | target || expected
//        [1, 10, 23] | 0 | 2 | 3      || 0
//        [1, 10, 23] | 0 | 2 | 1      || 0
//        [1, 10, 23] | 0 | 2 | 10     || 1
//        [1, 10, 23] | 0 | 2 | 22     || 1
//        [1, 10, 23] | 0 | 2 | 23     || 2
//        [1, 10, 23] | 0 | 2 | 24     || 2
//        [1, 10, 23] | 0 | 2 | 0      || -1
//    }
}
