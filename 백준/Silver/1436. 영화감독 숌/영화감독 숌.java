import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int title = 665;
        String str = "";
        int cnt = 0;

        while(true) {
            title++;
            str = String.valueOf(title);
            if(str.contains("666")) {
                cnt++;
            }
            if(N == cnt) break;
        }
        System.out.println( title);
    }
}