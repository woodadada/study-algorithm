import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int[][] arr;
    public static boolean[] visited;
    public static int N, M;
    public static Set<Integer> set = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }

        bfs(1);
        System.out.println(set.size());
    }
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int i = 1; i <= N; i++) {
                if(arr[poll][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[poll] = true;
                    set.add(i);
                }
            }
        }
    }
}