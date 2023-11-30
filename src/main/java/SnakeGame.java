public class SnakeGame {
    public static void main(String[] args) {
        SnakeGameHandler snakeGameHandler = new SnakeGameHandler(10, 10, 4);
        SnakeGameHandler.MOVE RIGHT = SnakeGameHandler.MOVE.RIGHT;
        SnakeGameHandler.MOVE DOWN = SnakeGameHandler.MOVE.DOWN;

        snakeGameHandler.printBoard();

        snakeGameHandler.moveSnakeAndPrint(DOWN);
        snakeGameHandler.moveSnakeAndPrint(DOWN);
        snakeGameHandler.moveSnakeAndPrint(RIGHT);
        snakeGameHandler.moveSnakeAndPrint(RIGHT);
        snakeGameHandler.moveSnakeAndPrint(RIGHT);
        snakeGameHandler.moveSnakeAndPrint(RIGHT);
        snakeGameHandler.moveSnakeAndPrint(RIGHT);
        snakeGameHandler.moveSnakeAndPrint(RIGHT);
        snakeGameHandler.moveSnakeAndPrint(RIGHT);
        snakeGameHandler.moveSnakeAndPrint(DOWN);
        snakeGameHandler.moveSnakeAndPrint(DOWN);
        snakeGameHandler.moveSnakeAndPrint(DOWN);
        snakeGameHandler.moveSnakeAndPrint(DOWN);
        snakeGameHandler.moveSnakeAndPrint(DOWN);
        snakeGameHandler.moveSnakeAndPrint(DOWN);
        snakeGameHandler.moveSnakeAndPrint(DOWN);
        snakeGameHandler.moveSnakeAndPrint(DOWN);
    }
}
