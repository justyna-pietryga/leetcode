import java.util.ArrayList;
import java.util.List;

public class DfsConnections {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < (n - 1)) return -1;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] connection : connections) {
            int vertex1 = connection[0];
            int vertex2 = connection[1];
            graph.get(vertex1).add(vertex2);
            graph.get(vertex2).add(vertex1);
        }

        boolean[] visited = new boolean[n];
        int connectedDevicesCount = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                connectedDevicesCount++;
                dfs(i, visited, graph);
            }
        }

        return connectedDevicesCount - 1;
    }

    private void dfs(int current, boolean[] isVisited, List<List<Integer>> graph) {
        if (isVisited[current]) return;
        isVisited[current] = true;
        for (int dest : graph.get(current)) {
            dfs(dest, isVisited, graph);
        }
    }
}
