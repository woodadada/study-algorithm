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
        String[] checkList = {"c=", "c-", "d-", "lj", "nj", "s=", "z="};
        String[] checkList1 = {"dz="};
        String s = br.readLine();
        int len = s.length();

        int count = 0;
        for (int i = 0; i < len; i++) {
            int end = i;
            if(len - i >= 3) {
                end = i + 3;
                String substring = s.substring(i, end);
                boolean flag = false;
                for (int j = 0; j < checkList1.length; j++) {
                    if(substring.equals(checkList1[j])) {
                        count++;
                        i = end - 1;
                        flag = true;
                    }
                }
                if(flag) continue;
            }
            if(len - i >= 2) {
                end = i + 2;
                String substring = s.substring(i, end);
                boolean flag = false;
                for (int j = 0; j < checkList.length; j++) {
                    if(substring.equals(checkList[j])) {
                        count++;
                        i = end - 1;
                        flag = true;
                    }
                }
                if(flag) continue;
            }

            count++;
        }
        System.out.println(count);
    }
}