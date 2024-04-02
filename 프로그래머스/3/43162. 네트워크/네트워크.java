import java.util.*;
class Solution {
    static List<List<Integer>> list;
    static boolean[] visited;
    static int N;
    
    public static int solution(int n, int[][] computers) {
        // 초기화
        N = n;
        list = new ArrayList<>();
        visited = new boolean[N + 1];

        // 인접 리스트
        for(int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            int[] computer = computers[i];
            for(int k = 0; k < computer.length; k++) {
                if(1 == computer[k]) {
                    list.get(i + 1).add(k + 1);
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if(!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        return answer;
    }

    public static void dfs(int n){
        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        visited[n] = true;

        while(!stack.isEmpty()) {
            Integer pop = stack.pop();

            for (Integer i : list.get(pop)) {
                if (!visited[i]) {
                    visited[i] = true;
                    stack.push(i);
                }
            }
        }
    }
}