public class SnakeGameHandler {
    private boolean[][] board;
    private Snake snake;
    private MOVE direction;

    public SnakeGameHandler(int height, int weight) {
        this.board = new boolean[height][weight];
        this.snake = new Snake();
        updateBoard(0, 0, true);
    }

    public SnakeGameHandler(int height, int weight, int size) {
        this.board = new boolean[height][weight];
        this.snake = new Snake();
        updateBoard(0, 0, true);
        for (int i = 1; i < size; i++) {
            updateBoard(0, i, true);
            snake.addHeadToSnake(0, i);
        }
    }

    public void moveSnake(MOVE direction) {
        this.direction = direction;
        Integer[] lastPosition = snake.removeTail();
        Integer[] headPosition = snake.getHead();
        int newX_Position = calculateNewPosition(headPosition[0], direction.getMovesDown());
        int newY_Position = calculateNewPosition(headPosition[1], direction.getMovesRight());
        snake.addHeadToSnake(newX_Position, newY_Position);
        updateBoard(lastPosition[0], lastPosition[1], false);
        updateBoard(newX_Position, newY_Position, true);
    }

    public void moveSnakeAndPrint(MOVE move) {
        moveSnake(move);
        printBoard();
    }

    private int calculateNewPosition(int headX, int moves) {
        if (moves == 0) return headX;
        int added = headX + moves;
        if (added < board.length) return added;
        return board.length % added;
    }

    public void updateBoard(int x, int y, boolean state) {
        board[x][y] = state;
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char sign = board[i][j] ? 'X' : '_';
                System.out.print(" " + sign + " ");
            }
            System.out.println();
        }

        System.out.println("+++++++++++++++++++");
    }

    public enum MOVE {
        UP(-1, 0),
        DOWN(1, 0),
        LEFT(0, -1),
        RIGHT(0, 1);

        private final int movesDown;
        private final int movesRight;

        MOVE(int movesDown, int movesRight) {
            this.movesDown = movesDown;
            this.movesRight = movesRight;
        }

        public int getMovesDown() {
            return movesDown;
        }

        public int getMovesRight() {
            return movesRight;
        }
    }
}
