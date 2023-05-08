import java.util.*;

/**
 * 13-Apr-23
 * <a href="https://leetcode.com/problems/minimum-path-sum/"/a>
 * using Dijkstra algorithm
 * yeah, I know it's overkill here :D
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int[][] result = new int[grid.length][grid[0].length];
        result[0][0] = grid[0][0];
        int elementsInRow = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int currentCost = ((i == 0 && j == 0) || result[i][j] == 0) ? grid[i][j] : result[i][j];
                int newCost;
                if (j < elementsInRow - 1) {
                    newCost = currentCost + grid[i][j + 1];
                    if (result[i][j + 1] == 0 || result[i][j + 1] > newCost)
                        result[i][j + 1] = newCost;
                }
                if (i < grid.length - 1) {
                    newCost = currentCost + grid[i + 1][j];
                    if (result[i + 1][j] == 0 || result[i + 1][j] > newCost)
                        result[i + 1][j] = newCost;
                }
            }
        }
        return result[grid.length - 1][grid[0].length - 1];
    }

    public int minPathSumDijkstra(int[][] grid) {
        List<List<Node>> nodesWithNeighbours = getConvertedNodesWithNeighbours(grid);
        int[] distance = new int[nodesWithNeighbours.size()];
        Set<Integer> settled = new HashSet<>();
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(Node::getCost));

        int firstCost = grid[0][0];
        distance[0] = firstCost;
        pq.add(new Node(0, firstCost));

        while (settled.size() < nodesWithNeighbours.size()) {
            Node u = pq.remove();
            int nodeId = u.getId();
            if (!settled.contains(nodeId)) {
                settled.add(nodeId);

                List<Node> nodes = nodesWithNeighbours.get(nodeId);

                for (Node neighbourNode : nodes) {
                    int edgeDist = neighbourNode.getCost();
                    int distFromSource = u.getCost() + edgeDist;
                    int neighbourNodeId = neighbourNode.getId();
                    if (distFromSource < distance[neighbourNodeId]) {
                        distance[neighbourNode.getId()] = distFromSource;
                    }
                    pq.add(new Node(neighbourNodeId, distance[neighbourNodeId]));
                }
            }
        }

        return distance[nodesWithNeighbours.size() - 1];
    }

    private List<List<Node>> getConvertedNodesWithNeighbours(int[][] grid) {
        List<List<Node>> nodesWithNeighbours = new ArrayList<>();

        int elementsInRow = grid[0].length;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < elementsInRow; j++) {
                List<Node> neighbours = new ArrayList<>();
                if (j < elementsInRow - 1) {
                    neighbours.add(new Node(elementsInRow * i + (j + 1), grid[i][j + 1]));
                }
                if (i < grid.length - 1) {
                    neighbours.add(new Node(elementsInRow * (i + 1) + j, grid[i + 1][j]));
                }
                nodesWithNeighbours.add(neighbours);
            }
        }

        return nodesWithNeighbours;
    }

    static class Node {
        private final int id;
        private final int cost;

        public Node(int id, int cost) {
            this.id = id;
            this.cost = cost;
        }

        public int getId() {
            return id;
        }

        public int getCost() {
            return cost;
        }
    }
}
