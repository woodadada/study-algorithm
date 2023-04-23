import java.util.LinkedList;
import java.util.Queue;
class Solution {
    int[] dx = {0, 0, 1, -1}; // row
    int[] dy = {1, -1, 0, 0}; // col
    
    public int solution(int[][] maps) {
        int[][] visited = new int[maps.length][maps[0].length];
        visited[0][0] = 1; // 시작 지점
        // bfs 탐색
        bfs(maps, visited);

        int answer = visited[maps.length - 1][maps[0].length - 1];
        return answer == 0 ? -1 : answer;
    }
    
    public void bfs(int[][] maps, int[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0], y = now[1];
            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                // 이동한 위치
                int nx = x + dx[i];
                int ny = y + dy[i];

                /**
                 * 1. 범위 체크
                 * 2. 방문 여부 체크
                 * 3. 벽이 아닌지 체크
                 */
                if(nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length
                        && visited[nx][ny] == 0 && maps[nx][ny] == 1) {
                    visited[nx][ny] = visited[x][y] + 1;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
    }
}