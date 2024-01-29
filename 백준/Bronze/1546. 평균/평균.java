import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Double[] arr = new Double[N];
        double max = Double.MIN_VALUE;

        // array 세팅, max 세팅
        for (int i = 0; i < N; i++) {
            String s = st.nextToken(" ");
            arr[i] = Double.parseDouble(s);
            max = Double.max(arr[i], max);
        }

        double sum = 0.0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / max * 100;
            sum += arr[i];
        }
        
        System.out.println(sum / N);
    }
}