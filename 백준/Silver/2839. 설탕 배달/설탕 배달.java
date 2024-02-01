import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        while(N > 0) {
            if (N % 5 == 0) {
                count += N / 5;
                N %= 5;
            } else {
                N -= 3;
                count++;
            }
        }

        if(N < 0) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }
}