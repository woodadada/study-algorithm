import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] nr = {1, -1, 0, 0};
    static int[] nc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    int bfs = bfs(new int[]{i, j});
                    list.add(bfs);
                }
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    static int bfs(int[] node) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(node);
        visited[node[0]][node[1]] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int row = poll[0];
            int col = poll[1];

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nextRow = row + nr[i];
                int nextCol = col + nc[i];

                if (check(nextRow, nextCol) && !visited[nextRow][nextCol] && map[nextRow][nextCol] == 1) {
                    queue.offer(new int[] {nextRow, nextCol});
                    visited[nextRow][nextCol] = true;
                    count++;
                }
            }
        }
        return count;
    }

    static boolean check(int nextRow, int nextCol) {
        return nextRow >= 0 && nextCol >= 0 && map.length > nextRow && map[0].length > nextCol;
    }
}