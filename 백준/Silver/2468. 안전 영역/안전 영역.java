import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int[][] map;
    public static int[][] safetyMap;
    public static boolean[][] visited;
    public static int[] dr = {1, -1, 0, 0};
    public static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int maxHigh = 0;

        // 블록 세팅, max 추출
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int high = Integer.parseInt(st.nextToken());
                map[i][j] = high;
                maxHigh = Math.max(maxHigh, high);
            }
        }

        int answer = 0;
        for (int i = 0; i <= maxHigh; i++) { // 최대 높이까지 안전한 구역 확인
            int count = 0;
            visited = new boolean[N][N];
            safetyMap = new int[N][N];
            // 높이 별 안전 구역 세팅
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] > i) {
                        safetyMap[j][k] = 1;
                    }
                }
            }

            // 모두 돌면서 침수 안된 곳 연결 찾기
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!visited[j][k] && safetyMap[j][k] == 1) {
                        bfs(new int[] {j, k});
                        count++;
                    }
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }

    public static void bfs(int[] node) {
        Queue<int []> queue = new LinkedList<>();
        queue.offer(node);
        visited[node[0]][node[1]] = true;

        while(!queue.isEmpty()) {
            node = queue.poll();
            int row = node[0];
            int col = node[1];

            // 상하좌우 방문
            for (int i = 0; i < 4; i++) {
                int nextRow = row + dr[i];
                int nextCol = col + dc[i];

                if(check(nextRow, nextCol, map) && !visited[nextRow][nextCol] && safetyMap[nextRow][nextCol] == 1) {
                    queue.offer(new int[] {nextRow, nextCol});
                    visited[nextRow][nextCol] = true;
                }
            }
        }
    }

    public static boolean check(int nr, int nc, int[][] map) {
        return nr >= 0 && nc >= 0 && nr < map.length && nc < map[0].length;
    }
}