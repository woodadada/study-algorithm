import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = st.countTokens();
        int total = 0;
        for (int i = 0; i < count; i++) {
            String s1 = st.nextToken();
            int num = Integer.parseInt(s1);
            total += num;
        }
        System.out.println(String.valueOf(total));
    }
}
