import java.util.*;

public class Main {

    public static int isEscapePossible(int n, int m, int[][] grid) {
        // BFS를 위한 큐
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});  // 시작 지점은 (0, 0)
        
        // 방문 여부를 기록하기 위한 배열
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;  // 시작 지점 방문 처리
        
        // BFS 탐색
        int[][] directions = {{1, 0}, {0, 1}};  // 아래(1,0)와 오른쪽(0,1)
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            // 우측 하단에 도달했으면 탈출 가능
            if (x == n - 1 && y == m - 1) {
                return 1;
            }
            
            // 두 방향(아래, 오른쪽)으로 이동
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                
                // 범위 체크와 뱀이 없고, 방문하지 않은 칸인지 확인
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && grid[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
        
        // 큐를 모두 탐색한 후에 탈출 불가능
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 입력 받기
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        // 결과 출력
        System.out.println(isEscapePossible(n, m, grid));
        
        scanner.close();
    }
}
