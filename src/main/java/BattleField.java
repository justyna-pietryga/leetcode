import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BattleField {
    public static final int MAX_SIZE = 10;

    public static boolean fieldValidator(int[][] field) {

        Set<Point> points = new HashSet<>();
        List<List<Point>> ships = new ArrayList<>(new ArrayList<>());

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 1) points.add(new Point(i, j));
            }
        }

        if (points.size() < 20) return false;
        for (Point point : new HashSet<>(points)) {
            if (points.contains(point)) {
                List<Point> ship = point.findShip(points);
                ships.add(ship);
                ship.forEach(points::remove);
                System.out.println("ship: " + ship);
                System.out.println();
            }
            System.out.println("ships: " + ships);
            System.out.println(ships.stream()
                    .map(List::size)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
        }


        return validate(ships);
    }

    private static boolean validate(List<List<Point>> ships) {
        if (ships.size() != 10) return false;
        Map<Integer, Long> map = ships.stream()
                .map(List::size)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        if (!map.keySet().equals(new HashSet<>(List.of(4,3,2,1)))) return false;
        return true;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public List<Point> findShip(Collection<Point> points) {
            List<Point> ship = new LinkedList<>();
            ship.add(this);
            int x_tmp = this.x;
            int y_tmp = this.y;

            while (x > 0) {
                Point nextPoint = new Point(--x, y);
                if (points.contains(nextPoint)) ship.add(nextPoint);
                else break;
            }
            x = x_tmp;
            while (x < BattleField.MAX_SIZE - 1) {
                Point nextPoint = new Point(++x, y);
                if (points.contains(nextPoint)) ship.add(nextPoint);
                else break;
            }
            x = x_tmp;
            while (y > 0) {
                Point nextPoint = new Point(x, --y);
                if (points.contains(nextPoint)) ship.add(nextPoint);
                else break;
            }
            y = y_tmp;
            while (y < BattleField.MAX_SIZE - 1) {
                Point nextPoint = new Point(x, ++y);
                if (points.contains(nextPoint)) ship.add(nextPoint);
                else break;
            }
            return ship;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "{x=" + x + ", y=" + y + "}";
        }
    }
}