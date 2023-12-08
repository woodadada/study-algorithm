import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < cnt; i++) {
            int total = 0;
            int score = 0;
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            String[] split = str.split("");
            
            for (int j = 0; j < split.length; j++) {
                String s = split[j];
                if(s.equals("O")) {
                    score++;
                    total += score;
                } else {
                    score = 0;
                }
            }
            sb.append(total).append("\n");
        }
        System.out.println(sb.toString());
    }
}