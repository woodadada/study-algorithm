import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String s1 = st.nextToken();
        int i = Integer.parseInt(s1);
        for (int j = 0; j < i; j++) {
            for (int i1 = 0; i1 <= j; i1++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}