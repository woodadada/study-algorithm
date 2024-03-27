import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int count = 0;
        for (int k = 0; k < 3; k++) {
            if(0 == k) {
                count += check('R');
            } else if (1 == k) {
                count += check('B');
            } else {
                count += check('G');
            }
        }
        System.out.println(count);

        change();
        visited = new boolean[N][N];
        count = 0;
        for (int k = 0; k < 2; k++) {
            if(0 == k) {
                count += check('X');
            } else {
                count += check('B');
            }
        }
        System.out.println(count);

    }
    public static int check(char type) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == type && !visited[i][j]) {
                    bfs(new int[] {i, j}, type);
                    count++;
                }
            }
        }
        return count;
    }

    public static void change() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 'R' || map[i][j] == 'G') {
                    map[i][j] = 'X';
                }
            }
        }
    }

    public static void bfs(int[] node, char type) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(node);
        visited[node[0]][node[1]] = true;

        while(!queue.isEmpty()) {
            node = queue.poll();
            int row = node[0];
            int col = node[1];

            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(check(nr, nc) && !visited[nr][nc] && map[nr][nc] == type) {
                    queue.offer(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
    }

    public static boolean check(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < map.length && nc < map[0].length;
    }
}