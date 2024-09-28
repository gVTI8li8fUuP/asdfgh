import java.util.*;
public class DFS {
    private final int V; // Number of vertices
    private final LinkedList<Character>[] adj; // Adjacency Lists

    // Constructor
    public DFS(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    // Function to add an edge into the graph
    public void addEdge(char v, char w) {
        int vIndex = v - 'A';
        int wIndex = w - 'A';
        adj[vIndex].add(w);
        adj[wIndex].add(v); // Since the graph is undirected
    }

    // Depth First Search (DFS)
    public void dfs() {
        boolean[] visited = new boolean[V];
        for (int v = 0; v < V; v++) {
            if (!visited[v]) {
                visitVertex(v, visited);
            }
        }
    }

    // Visit a vertex in DFS traversal
    private void visitVertex(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print((char) (v + 'A') + " ");

        for (int w : adj[v]) {
            if (!visited[w]) {
                visitVertex(w, visited);
            }
        }
    }

    // Driver code
    public static void main(String[] args) {
        DFS g = new DFS(7);

        // Adding edges according to the provided graph
        g.addEdge('A', 'B');
        g.addEdge('A', 'C');
        g.addEdge('A', 'D');
        g.addEdge('B', 'C');
        g.addEdge('B', 'E');
        g.addEdge('B', 'G');
        g.addEdge('C', 'D');
        g.addEdge('E', 'F');
        g.addEdge('E', 'G');
        g.addEdge('F', 'G');

        System.out.println("Following is Depth First Traversal:");

        g.dfs(); // Start DFS traversal
    }
}
