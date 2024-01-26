import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String str = st.nextToken();

        int total = 0;
        for (int i = 0; i < cnt; i++) {
            char c = str.charAt(i);
            total += Integer.parseInt(Character.toString(c));
        }
        System.out.println(total);
    }
}