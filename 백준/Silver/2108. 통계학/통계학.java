import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
            
            max = Math.max(max, count);
            sum += num;
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(max == entry.getValue()) {
                list.add(entry.getKey());
            }
        }
        Arrays.sort(arr);
        Collections.sort(list);
        double average = (double) sum / arr.length;
        System.out.println((int) Math.round(average));
        System.out.println(arr[arr.length / 2]);
        if(list.size() > 1) {
            System.out.println(list.get(1));
        } else {
            System.out.println(list.get(0));
        }
        System.out.println(arr[n - 1] - arr[0]);

    }
}