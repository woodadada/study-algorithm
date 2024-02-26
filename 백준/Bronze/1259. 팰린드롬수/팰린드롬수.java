import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        while(true) {
            String s = br.readLine();
            if(s.equals("0")) break;
            StringBuilder sb = new StringBuilder(s);
            sb = sb.reverse();

            if (s.equalsIgnoreCase(sb.toString())) {
                answer.append("yes").append("\n");
            } else {
                answer.append("no").append("\n");
            }
        }
        System.out.println(answer);
    }
}