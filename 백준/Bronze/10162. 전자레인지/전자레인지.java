import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] second = {300, 60, 10};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < second.length; i++) {
            int count = (T / second[i]);
            T %= second[i];
            sb.append(count).append(" ");
        }
        // StringBuilder 초기화
        if (T > 0) {
            sb.delete(0, sb.length()).append(-1);
        }
        System.out.println(sb.toString());
    }
}