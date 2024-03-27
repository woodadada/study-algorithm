import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int C, I;
    static int[][] map;
    static int[] target;
    static int[][] visited;
    static int[] dr = {2, 1, -2, -1, -2, -1, 1, 2};
    static int[] dc = {1, 2, 1, 2, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        C = Integer.parseInt(br.readLine());
        for (int i = 0; i < C; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            I = Integer.parseInt(st.nextToken());
            map = new int[I][I];
            visited = new int[I][I];
            st = new StringTokenizer(br.readLine());
            int[] night = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            st = new StringTokenizer(br.readLine());
            target = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            for (int j = 0; j < I; j++) {
                for (int k = 0; k < I; k++) {
                    if (target[0] == j && target[1] == k) {
                        map[j][k] = 1;
                    }
                }
            }
            bfs(night);
            System.out.println(visited[target[0]][target[1]] - 1);
        }

    }

    public static void bfs(int[] node) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(node);
        visited[node[0]][node[1]] = 1;

        while(!queue.isEmpty()) {
            node = queue.poll();
            int row = node[0];
            int col = node[1];

            if (row == target[0] && col == target[1]) break;
            for (int i = 0; i < 8; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(check(nr, nc, map) && visited[nr][nc] == 0) {
                    visited[nr][nc] = visited[row][col] + 1;
                    map[nr][nc] = 5;
                    queue.offer(new int[] {nr, nc});
                }
            }
        }
    }

    public static boolean check(int nr, int nc, int[][] map) {
        return nr >= 0 && nc >= 0 && nr < map.length && nc < map[0].length;
    }
}