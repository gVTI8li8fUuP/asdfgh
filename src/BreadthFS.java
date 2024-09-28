import java.util.*;
public class BreadthFS {
    private final int V;
    private final LinkedList<Character>[] adj;
    public BreadthFS(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; ++i) {
            adj[i] = new LinkedList<>();
        }    }
    public void addEdge(char v, char w) {
        int vIndex = v - 'A';
        int wIndex = w - 'A';
        adj[vIndex].add(w);
        adj[wIndex].add(v);
    }
    public void sortAdjLists() {
        for (int i = 0; i < V; i++) {
            Collections.sort(adj[i]);
        }    }
    public void BFS(char source) {
        boolean[] visited = new boolean[V];
        LinkedList<Character> queue = new LinkedList<>();
        visited[source - 'A'] = true;
        queue.add(source);
        while (!queue.isEmpty()) {
            char s = queue.poll();
            System.out.print(s + " ");
            for (char n : adj[s - 'A']) {
                if (!visited[n - 'A']) {
                    visited[n - 'A'] = true;
                    queue.add(n);
                }            }        }    }
    public static void main(String[] args) {
        BreadthFS g = new BreadthFS(7);
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
        g.sortAdjLists();
        System.out.println(" BFS: ");
        g.BFS('A');
    }}
