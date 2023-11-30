import java.util.LinkedList;

public class Snake {
    LinkedList<Integer[]> body = new LinkedList<>();

    public Snake() {
        this.body.add(new Integer[]{0, 0});
    }

    public void addHeadToSnake(int x, int y) {
        this.body.addLast(new Integer[]{x, y});
    }

    public Integer[] removeTail() {
        return this.body.pollFirst();
    }

    public Integer[] getHead() {
        return this.body.getLast();
    }

    public LinkedList<Integer[]> getCurrentPositions() {
        return this.body;
    }
}
