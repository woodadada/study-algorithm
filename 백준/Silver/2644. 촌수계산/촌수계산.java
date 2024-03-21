import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int[][] arr;
    public static boolean[] visited;
    public static int[] depth;
    public static int N, M, X, Y;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        arr = new int[N+1][N+1];
        visited = new boolean[N+1];
        depth = new int[N+1];
        for (int i = 0; i < M; i++) { // 인접 행렬 초기화
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }
        System.out.println(bfs(X));
    }
    public static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int count = 0;

        while(!queue.isEmpty()) {
            Integer poll = queue.poll();
            if(poll == Y) break;

            for (int i = 1; i <= N; i++) {
                if(arr[poll][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    depth[i] = depth[poll] + 1;
                }
            }
        }

        return depth[Y] == 0 ? -1 : depth[Y];
    }
}