import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(st.nextToken());
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int repeat = Integer.parseInt(st.nextToken());
            String[] str = st.nextToken().split("");
            
            for (int i1 = 0; i1 < str.length; i1++) {
                for (int i2 = 0; i2 < repeat; i2++) {
                    sb.append(str[i1]);
                }                
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}