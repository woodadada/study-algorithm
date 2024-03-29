import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node {
        int node;
        int weight;

        Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    static int N, M, K, X;
    static int[][] map;
    static List<List<Integer>> list;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 도시
        M = Integer.parseInt(st.nextToken()); // 간선
        K = Integer.parseInt(st.nextToken()); // 이동 비용
        X = Integer.parseInt(st.nextToken()); // 시작점
        list = new ArrayList<>();
        visited = new int[N + 1];
        Arrays.fill(visited, -1);

        // 초기화
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
        }

        bfs(X);
        StringBuilder sb = new StringBuilder();
        boolean hasNode = false;
        for (int i = 1; i < visited.length; i++) {
            if(visited[i] == K) {
                sb.append(i).append("\n");
                hasNode = true;
            }
        }

        if (hasNode) {
            System.out.println(sb.toString());
        } else {
            System.out.println(-1);
        }
    }

    public static void bfs(int start) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, 0));
        visited[start] = 0;

        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            int index = poll.node;
            int weight = poll.weight;
            if(weight > K) break;

            for (Integer node : list.get(index)) {
                if(visited[node] == -1) {
                    visited[node] = visited[index] + 1;
                    queue.offer(new Node(node, weight + 1));
                }
            }
        }
    }
}