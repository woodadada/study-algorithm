import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int[][] map;
    public static boolean[][] visited;
    // 오른쪽과 아래만 이동 가능
    public static int[] dr = {1, 0};
    public static int[] dc = {0, 1};


    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        // map 초기화
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map.length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();

        if(visited[N-1][N-1]) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0,0});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int row = poll[0];
            int col = poll[1];
            int now = map[row][col];

            if(now == -1) {
                break;
            }

            // 오른쪽, 아래만 방문 가능
            for (int i = 0; i < 2; i++) {
                int nr = row + dr[i] * now;
                int nc = col + dc[i] * now;
                if(!check(nr, nc) || visited[nr][nc]) continue;

                visited[nr][nc] = true;
                queue.offer(new int[] {nr, nc});
            }
        }
    }
    public static boolean check(int row, int col) {
        return row >= 0 && col >= 0 && row < map.length && col < map.length;
    }
}