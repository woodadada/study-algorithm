import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        TreeSet set = new TreeSet();
        for (int j = 0; j < i; j++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int x = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int j = 0; j < x; j++) {
            if (set.contains(Integer.parseInt(st.nextToken()))) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}