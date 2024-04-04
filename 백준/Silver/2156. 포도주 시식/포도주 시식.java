import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wines = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            wines[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];
        dp[1] = wines[1];
        for (int i = 2; i <= n; i++) {
            if(i == 2) {
                dp[2] = wines[1] + wines[2];
                continue;
            }
            if(i == 3) {
                dp[3] = Math.max(dp[2], Math.max(wines[1] + wines[3], wines[2] + wines[3])); // OOX, OXO, XOO 중 가장 큰 값
                continue;
            }

            // OOX, XOO, OXO
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 3] + wines[i] + wines[i - 1], dp[i - 2] + wines[i]));
        }
        System.out.println(dp[n]);
    }
}