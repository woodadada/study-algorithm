import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int total = 0;
        for (int i = 0; i < 5; i++) {
            String str = st.nextToken();
            total += Math.pow(Integer.parseInt(str), 2);
        }
        System.out.println(total % 10);
    }
}