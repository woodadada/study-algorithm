import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static boolean[] visited;
    static int[] depth = new int[N + 1];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 유저 수
        M = Integer.parseInt(st.nextToken()); // 친구 관계 수
        arr = new int[N + 1][N + 1];

        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1; // 노드 간의 간선 표현인 인접 행렬 초기화
        }

        int max = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 1; i <= N; i++) {
            depth = new int[N + 1];
            int sum = bfs(i);

            if(sum < max) {
                max = sum;
                index = i;
            }
//            System.out.println(Arrays.toString(depth));
//            System.out.println("sum = " + sum);
        }

        System.out.println(index);
    }

    public static int bfs(int start) {
        visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            start = q.poll();
//            System.out.println("start = " + start);
            // 1부터 시작, 이어진 간선만 방문
            for (int i = 1; i <= N; i++) {
                if(arr[i][start] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                    depth[i] = depth[start] + 1;
//                    System.out.println("i = " + i);
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < depth.length; i++) {
            sum += depth[i];
        }

        return sum;
    }
}