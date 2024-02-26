import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        int index = 0;
        int answer = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            index++;
            if(index % 2 == 1) {
                answer = poll;
            } else {
                queue.add(poll);
            }
        }
        System.out.println(answer);
    }
}