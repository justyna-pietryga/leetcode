import java.util.LinkedList;

public class UnreachablePairs {
    public long countPairs(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        LinkedList<Integer>[] graph = createGraph(edges, n);
        long result = 0L;
        long nCopy = n;

        for (int i = 0; i < n; i++) {
            long nodesCount = dfs(graph, visited, i);
            nCopy -= nodesCount;
            result += nodesCount * nCopy;
        }

        return result;
    }

    public LinkedList<Integer>[] createGraph(int[][] edges, int n) {
        LinkedList<Integer>[] graph = new LinkedList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        return graph;
    }

    public long dfs(LinkedList<Integer>[] graph, boolean[] visited, int current) {
        if (visited[current]) return 0;
        visited[current] = true;
        long nodes = 0;

        for (int children : graph[current]) {
            nodes += dfs(graph, visited, children);
        }

        return ++nodes;
    }
}
