import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static long[] memo;
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        memo = new long[N+1];
        long A = factorial(N);
        long B = factorial(K);
        long C = factorial(N - K);
        
        System.out.println(A / (B * C));
    }
    private static long factorial(int n) {
        if (n == 0 || n == 1) {
            memo[n] = 1;
        } else if (memo[n] == 0) {
            memo[n] = n * factorial(n - 1);
        }
        return memo[n];
    }
}