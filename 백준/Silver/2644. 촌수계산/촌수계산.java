import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, A, B;
    static List<List<Integer>> list;
    static boolean[] visited;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        depth = new int[N + 1];
        Arrays.fill(depth, -1);
        list = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        // 인접 리스트 세팅
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
            list.get(y).add(x);
        }
        dfs();
        System.out.println(depth[B]);
    }

    public static void dfs() {
        Stack<Integer> stack = new Stack<>();
        stack.push(A);
        depth[A] = 0;
        visited[A] = true;

        while(!stack.isEmpty()) {
            Integer pop = stack.pop();
            if(pop == B) break;

            for (Integer i : list.get(pop)) {
                if(!visited[i]) {
                    stack.push(i);
                    depth[i] = depth[pop] + 1;
                    visited[i] = true;
                }
            }
        }
    }
}