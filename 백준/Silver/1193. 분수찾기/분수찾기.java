import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int count = 0;
        int index = 0;
        int deno = 0;
        int numer = 0;
        while(count < x) {
            index++;
            count += index;
        }

        if(index % 2 == 0) {
            deno = 1 + (count - x);
            numer = index - (count - x);
        } else {
            deno = index - (count - x);
            numer = 1 + (count - x);
        }

        System.out.println(numer + "/" + deno);
    }
}