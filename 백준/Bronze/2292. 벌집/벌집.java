import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 1,2,7,8,19,20,37...   경계가 6씩 증가 규칙 6,12,18
        int sum = 1;
        int idx = 1;
        while(true) {
            if (sum == N) break;
            sum += idx * 6;
            idx++;

            if (sum > N) {
                break;
            }
        }
        System.out.println(idx);

    }
}