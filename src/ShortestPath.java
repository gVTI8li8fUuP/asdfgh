import java.util.*;

public class ShortestPath {

    // Function to implement Dijkstra's algorithm
    public static List<Integer> dijkstra(int[][] graph, int source, int destination) {
        int V = graph.length;
        Set<Integer> settled = new HashSet<>();
        Map<Integer, Integer> distance = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();

        // Initialize all distances as INFINITY and parent as -1
        for (int i = 0; i < V; i++) {
            distance.put(i, Integer.MAX_VALUE);
            parent.put(i, -1);
        }

        // Distance to source is 0
        distance.put(source, 0);

        // Use a priority queue to select the vertex with the minimum distance
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.add(new Node(source, 0));

        // Find shortest paths for all vertices
        while (!pq.isEmpty()) {
            int u = pq.poll().vertex;
            settled.add(u);

            for (int v : graph[u]) {
                int alt = distance.get(u) + graph[u][v];
                if (!settled.contains(v) && alt < distance.get(v)) {
                    distance.put(v, alt);
                    parent.put(v, u);
                    pq.add(new Node(v, alt));
                }
            }
        }

        // Reconstruct the path from destination to source
        List<Integer> path = new ArrayList<>();
        int curr = destination;
        if (parent.get(curr) == -1) {
            return null; // No path exists
        }
        while (curr != source) {
            path.add(curr);
            curr = parent.get(curr);
        }
        path.add(source);
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        // Assuming the adjacency list representation of the Scottish road network graph
        // Replace this with the actual graph data
        int[][] graph = new int[][]{
                {0, 70, 0},
                {70, 0, 100},
                {0, 100, 0}
        };

        int source = 0; // Edinburgh (index 0)
        int destination = 1; // Dundee (index 1)

        List<Integer> shortestPath = dijkstra(graph, source, destination);

        if (shortestPath != null) {
            System.out.println("Shortest path from Edinburgh to Dundee: ");
            for (int node : shortestPath) {
                System.out.print(node + " -> ");
            }
            System.out.println("Total distance: " + distance.get(destination));
        } else {
            System.out.println("No path exists from Edinburgh to Dundee.");
        }
    }

    static class Node {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}
