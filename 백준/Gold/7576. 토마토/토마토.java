import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int[][] map;
    public static int[] dr = {1, -1, 0, 0};
    public static int[] dc = {0, 0, 1, -1};
    public static Queue<int []> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // col
        int N = Integer.parseInt(st.nextToken()); // row
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    queue.offer(new int[] {i, j}); // 시작 토마토
                }
            }
        }
        bfs();
    }

    public static void bfs() {
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];

            // 상하좌우 토마토 익히기
            for (int i = 0; i < 4; i++) {
                int nextRow = row + dr[i];
                int nextCol = col + dc[i];
                if(check(nextRow, nextCol, map) && map[nextRow][nextCol] == 0) {
                    map[nextRow][nextCol] = map[row][col] + 1;
                    queue.offer(new int[] {nextRow, nextCol});
                }
            }
        }

        int max = Integer.MIN_VALUE;
        boolean hasZero = false;
        // 주변 토마토를 모두 순회하고도 익지 않은 토마토가 있는지 확인
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                max = Math.max(max , map[i][j]);
                if(map[i][j] == 0) {
                    hasZero = true;
                }
            }
        }

        if(hasZero) {
            System.out.println(-1);
        } else {
            System.out.println(max - 1);
        }
    }

    public static boolean check(int nr, int nc, int[][] map) {
        return nr >= 0 && nc >= 0 && nr < map.length && nc < map[0].length;
    }
}