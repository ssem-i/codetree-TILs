import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int reachableCount;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        int m = sc.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        visited = new boolean[n + 1];
        reachableCount = 0;
        dfs(1);

        System.out.println(reachableCount);
    }

    public static void dfs(int node) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                reachableCount++; 
                dfs(neighbor);    
            }
        }
    }
}
