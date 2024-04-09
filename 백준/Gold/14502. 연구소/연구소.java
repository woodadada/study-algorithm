import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static List<int[]> wall = new ArrayList<>();
    static List<int[]> virus = new ArrayList<>();
    static boolean[][] visited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int n, m;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                // 벽 세울 수 있는 곳
                if(num == 0) wall.add(new int[] {i, j});
                // 바이러스 시작점
                if(num == 2) virus.add(new int[] {i, j});
            }
        }
        // 벽을 세우고
        // 바이러스 퍼트리고
        // 안전영역 확인
        int result = 0;
        int size = wall.size();
        for (int i = 0; i < size; i++) { // 벽 개수만큼의 위치 조합으로 벽을 세움
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < j; k++) {
                    // 벽 세우기
                    map[wall.get(i)[0]][wall.get(i)[1]] = 1;
                    map[wall.get(j)[0]][wall.get(j)[1]] = 1;
                    map[wall.get(k)[0]][wall.get(k)[1]] = 1;
                    // 바이러스 감염, 안전영역 확인
                    result = Math.max(result, go());
                    // 벽 제거
                    map[wall.get(i)[0]][wall.get(i)[1]] = 0;
                    map[wall.get(j)[0]][wall.get(j)[1]] = 0;
                    map[wall.get(k)[0]][wall.get(k)[1]] = 0;
                }
            }
        }
        System.out.println(result);
    }
    static int go() {
        // visited 초기화
        visited = new boolean[n][m];
        // 바이러스 감염
        for (int[] ints : virus) {
            visited[ints[0]][ints[1]] = true;
            dfs(ints[0], ints[1]);
        }
        // 안전 영역 확인
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0 && !visited[i][j]) count++;
            }
        }
        return count;
    }

    // 바이러스 퍼트리기
    static void dfs(int row, int col) {
        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue; // 방문 범위 체크
            if(visited[nr][nc]) continue; // 방문 여부 체크
            if(map[nr][nc] == 1) continue; // 벽 여부 확인

            visited[nr][nc] = true;
            dfs(nr, nc);
        }
    }
}