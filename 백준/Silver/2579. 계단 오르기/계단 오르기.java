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
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];
        if(n == 1) { // 계단 1층
            dp[1] = arr[1];
        } else if(n == 2) { // 계단 2층
            dp[2] = arr[2] + arr[1];
        } else {
            dp[1] = arr[1];
            dp[2] = arr[2] + arr[1];
            dp[3] = Math.max(arr[1] + arr[3], arr[2] + arr[3]); // 1-3, 2-3 경로 중 더 높은 점수 경로 선택
            //System.out.println(Arrays.toString(dp));
            //System.out.println("====");
            for (int i = 4; i <= n; i++) {
                // 1-3-4 경로와 2-4 경로 점수 중 더 높은 점수 경로 선택
                dp[i] = Math.max(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i]);
                //System.out.println(Arrays.toString(dp));
            }
        }

        System.out.println(dp[n]);
    }
}