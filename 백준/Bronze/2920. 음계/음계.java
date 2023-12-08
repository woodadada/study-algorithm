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
        int asc = 1;
        int desc = 8;

        for (int i = 0; i < 8; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num == asc) {
                asc++;
            }
            if(num == desc) {
                desc--;
            }
        }
        
        if(asc == 9) {
            System.out.print("ascending");
        } else if(desc == 0) {
            System.out.print("descending");
        } else {
            System.out.print("mixed");
        }
    }
}