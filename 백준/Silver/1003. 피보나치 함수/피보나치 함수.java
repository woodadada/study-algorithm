import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        dp[0][0] = 1; // 0일때 0호출 횟수
        dp[0][1] = 0; // 0일때 1호출 횟
        dp[1][0] = 0; // 1일때 0호출 횟수
        dp[1][1] = 1; // 1일때 1호춣 횟수
        fibonacci(40);
        
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
    }
    static Integer[][] dp = new Integer[41][2];

    public static Integer[] fibonacci(int n) {
        if(dp[n][0] == null || dp[n][1] == null) {
            dp[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
            dp[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
        }

        return dp[n];
    }
}