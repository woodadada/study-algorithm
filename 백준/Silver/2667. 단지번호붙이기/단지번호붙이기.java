import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dr = {1, -1, 0, 0};
    public static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        // 집 위치 초기화
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] split = st.nextToken().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        List<Integer> list = new ArrayList<>();
        int answer = 0;
        // 연결된 단지 수, 총 개수 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    int bfs = bfs(new int[]{i, j});
                    list.add(bfs);
                    answer++;
                }
            }
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");
        for (Integer i : list) {
            sb.append(i).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int bfs(int[] node) {
        Queue<int []> queue = new LinkedList<>();
        queue.offer(node);
        visited[node[0]][node[1]] = true;
        int count = 1;

        while(!queue.isEmpty()) {
            node = queue.poll();
            int row = node[0];
            int col = node[1];

            // 상하좌우 방문
            for (int i = 0; i < 4; i++) {
                int nextRow = row + dr[i];
                int nextCol = col + dc[i];
                if(check(nextRow, nextCol, map) && !visited[nextRow][nextCol] && map[nextRow][nextCol] == 1) {
                    queue.offer(new int[] {nextRow, nextCol});
                    count++;
                    visited[nextRow][nextCol] = true;
                }
            }
        }
        return count;
    }

    public static boolean check(int nr, int nc, int[][] map) {
        return nr >= 0 && nc >= 0 && nr < map.length && nc < map[0].length;
    }
}