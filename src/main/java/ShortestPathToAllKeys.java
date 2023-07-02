import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * 02-Jul-2023
 * <a href="https://leetcode.com/problems/shortest-path-to-get-all-keys"/>
 */

public class ShortestPathToAllKeys {
    private static final Character STARTING_POINT_CHAR = '@';
    private static final Character WALL_CHAR = '#';
    private static final int[][] MOVES = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int startX = -1;
    private int startY = -1;
    int keyMask = 0;

    public int shortestPathAllKeys(String[] grid) {
        Queue<CellState> queue = new LinkedList<>();
        Set<CellState> visited = new HashSet<>();
        int n = grid.length;
        int m = grid[0].length();
        int steps = 0;

        setUp(n, m, grid);

        CellState firstCellState = new CellState(startX, startY, 0);
        visited.add(firstCellState);
        queue.add(firstCellState);

        while (queue.size() > 0) {
            int amountOfPossibleMovesInNextStep = queue.size();

            while (amountOfPossibleMovesInNextStep-- > 0) {
                CellState currentCellState = queue.poll();
                if (currentCellState == null) return -1;

                for (int[] move : MOVES) {
                    int currentKeys = currentCellState.getKeys();
                    if (currentKeys == keyMask) {
                        return steps;
                    }

                    CellState nextCellState = computeMove(grid, n, m, currentCellState, move, currentKeys);

                    if (nextCellState != null && !visited.contains(nextCellState)) {
                        visited.add(nextCellState);
                        queue.add(nextCellState);
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    private CellState computeMove(String[] grid, int n, int m, CellState currentCellState, int[] move, int currentKeys) {
        int nextX = currentCellState.getI();
        int nextY = currentCellState.getJ();
        if (move[0] < 0 && currentCellState.getI() == 0 || move[0] > 0 && currentCellState.getI() == n - 1) {
            return null;
        }
        if (move[1] < 0 && currentCellState.getJ() == 0 || move[1] > 0 && currentCellState.getJ() == m - 1) {
            return null;
        }
        nextX += move[0];
        nextY += move[1];
        char nextCell = grid[nextX].charAt(nextY);
        if (nextCell == WALL_CHAR) {
            return null;
        } else if (isUpperChar(nextCell) && (!checkIfKeyWasFound(currentKeys, nextCell))) {
            return null;
        } else if (isLowerChar(nextCell)) {
            currentKeys = addKeyToKeys(currentKeys, nextCell);
        }

        return new CellState(nextX, nextY, currentKeys);
    }

    private void setUp(int n, int m, String[] grid) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char current = grid[i].charAt(j);
                if (current == STARTING_POINT_CHAR) {
                    startX = i;
                    startY = j;
                }
                if (isLowerChar(current)) {
                    keyMask = addKeyToKeys(keyMask, current);
                }
            }
        }
    }

    private int addKeyToKeys(int keys, int key) {
        return 1 << key - 'a' | keys;
    }

    private boolean checkIfKeyWasFound(int keys, int key) {
        return (1 << key - 'A' & keys) != 0;
    }

    private boolean isLowerChar(Character character) {
        return character >= 'a' && character <= 'z';
    }

    private boolean isUpperChar(Character character) {
        return character >= 'A' && character <= 'Z';
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    static class CellState {
        int i;
        int j;
        int keys;

        public CellState(int i, int j, int key) {
            this.i = i;
            this.j = j;
            this.keys = key;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        public int getKeys() {
            return keys;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CellState cellState = (CellState) o;
            return i == cellState.i && j == cellState.j && keys == cellState.keys;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j, keys);
        }
    }
}
