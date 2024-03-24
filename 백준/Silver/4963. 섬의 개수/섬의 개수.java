import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dr = {1, -1, 0, 0, -1, 1, -1, 1}; // 동서남북, 대각선
    public static int[] dc = {0, 0, 1, -1, 1, 1, -1, -1};

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String str = br.readLine();
            if(str.equals("0 0")) break; // 종료 조건

            StringTokenizer st = new StringTokenizer(str);
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            map = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) { // 지도 초기화
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(map[i][j] == 1 && !visited[i][j]){ // 섬 연결 부분과 방문하지 않은 곳 탐색
                        bfs(new int[] {i, j});
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static int bfs(int[] node) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(node);
        int row = node[0];
        int col = node[1];
        visited[row][col] = true;

        while(!queue.isEmpty()) {
            node = queue.poll();
            row = node[0];
            col = node[1];

            for (int i = 0; i < dr.length; i++) {
                int nextRow = row + dr[i];
                int nextCol = col + dc[i];
                if(!check(nextRow, nextCol, map) || visited[nextRow][nextCol]) continue;

                if(map[nextRow][nextCol] == 1) {
                    visited[nextRow][nextCol] = true;
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
        }
        return -1;
    }

    public static boolean check(int nr, int nc, int[][] map) {
        return nr >= 0 && nc >= 0 && nr < map.length && nc < map[0].length;
    }
}