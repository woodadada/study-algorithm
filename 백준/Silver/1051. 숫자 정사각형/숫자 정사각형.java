import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        int max = Math.max(n, m);
        int answer = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int leftUp = arr[i][j];
                for (int k = 1; k < max; k++) {
                    if(i + k >= n || j + k >= m) break;
                    int rightUp = arr[i][j + k];
                    int rightDown = arr[i + k][j + k];
                    int leftDown = arr[i + k][j];

                    if(leftUp == rightUp && leftUp == leftDown && leftUp == rightDown) {
                        answer = Math.max(answer, ((k + 1) * (k + 1)));
                    }
                }
            }
        }
        System.out.println(answer);
    }
}