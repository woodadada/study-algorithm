import java.util.*;
class Solution {
    static int[][] graph;

    public int solution(int n, int[][] wires) {
        int answer = n;
        // wires 요소 최대 값 + 1 배열 생성
        graph = new int[n+1][n+1];
        // 인접 행렬으로 그래프 표현
        for (int i = 0; i < wires.length; i++) {
            int start = wires[i][0], end = wires[i][1];
            graph[start][end] = 1;
            graph[end][start] = 1;
        }
        // for (int i = 0; i < graph.length; i++) {
        //     System.out.println(Arrays.toString(graph[i]));
        // }

        for (int i = 0; i < wires.length; i++) {
            int start = wires[i][0], end = wires[i][1];
            graph[start][end] = 0;
            graph[end][start] = 0;

            answer = Math.min(answer, bfs(n, start));
            // 간선 연결 복구
            graph[start][end] = 1;
            graph[end][start] = 1;
        }

        return answer;
    }

    public static int bfs(int n, int x) {
        boolean[] visited = new boolean[n+1];
        int count = 1;
        Queue<Integer> q = new LinkedList<>();
        // start는 제외 처리로 true
        visited[x] = true;
        q.offer(x);
        // 인접 행렬 4, new int[][]{{1,2},{2,3},{3,4}}
//        [0, 0, 0, 0, 0]
//        [0, 0, 1, 0, 0]
//        [0, 1, 0, 1, 0]
//        [0, 0, 1, 0, 1]
//        [0, 0, 0, 1, 0]
        while (!q.isEmpty()) {
            int temp = q.poll();
            // 인접 행렬 체크
            for (int i = 1; i <= n; i++) {
                if(graph[temp][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.offer(i); // index 자체로 간선 연결 판단
                    count++;
                }
            }
        }
        // 송전탑 개수 차이 구하기 count = 현재 보유 송전탑, n-count = 반대 보유 송전탑
        return Math.abs(count - (n - count));
    }
}