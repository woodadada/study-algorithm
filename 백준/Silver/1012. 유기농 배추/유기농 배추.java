import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M, N, K, count;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로
            N = Integer.parseInt(st.nextToken()); // 세로
            K = Integer.parseInt(st.nextToken()); // 배추 개수
            map = new int[N][M];
            visited = new boolean[N][M];

            // 배추 심어져 있는 map 초기화
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); // 가로
                int y = Integer.parseInt(st.nextToken()); // 세로
                map[y][x] = 1;
            }

            count = 0;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if(map[y][x] == 1 && !visited[y][x]) { // 배추 심어진 곳에 지렁이 넣기
                        count++;
                        bfs(x, y); // 지렁이가 배추있는 곳을 모두 찾아감
                    }
                }
            }

            System.out.println(count);
        }
    }
    public static void print() {
        System.out.println("================================");
        for (int i = 0; i < map.length; i++) {
            int[] ints = map[i];
            boolean[] booleans = visited[i];
//            System.out.println(Arrays.toString(ints));
            System.out.println(Arrays.toString(booleans));
        }
    }
    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        visited[y][x] = true;

        while(!q.isEmpty()) {
            int[] poll = q.poll();
            y = poll[0];
            x = poll[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                // 상하좌우 범위 내, 방문하지 않으면 q에 offer, 배추 심어진 곳 확인
                if(check(nx, ny) && !visited[ny][nx] && map[ny][nx] == 1) {
                    q.offer(new int[]{ny, nx});
                    visited[ny][nx] = true;
                }
            }
        }
    }

    public static boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < M && y < N;
    }
}