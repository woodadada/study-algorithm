import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] map;
    static int[][] visited;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];
        // map 세팅
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j)-'0';
            }
        }
        bfs();
        System.out.println(visited[N-1][M-1]);
    }
    public static void print(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(visited[i][j]);
                System.out.print("  ");
            }
            System.out.println();
        }
    }
    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        visited[0][0] = 1;
        while (!queue.isEmpty()) {
            //print();
            //System.out.println();
            int[] currLocation = queue.poll();
            int r = currLocation[0];
            int c = currLocation[1];
            if(r==N-1 && c==M-1) return;
            for (int i = 0; i < 4; i++) {
                int nr = dr[i]+r;
                int nc = dc[i]+c;
                if(!check(nr,nc) || visited[nr][nc] != 0) continue;
                if(map[nr][nc]!=1) continue;
                visited[nr][nc] = visited[r][c]+1;
                queue.offer(new int[]{nr,nc});
            }

        }


    }
    public static boolean check(int r, int c){
        return r>=0 && c>=0 && r<N && c<M;
    }
}