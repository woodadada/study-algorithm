import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        int total = getTotalSecond(hour, minute);
        int minusSecond = 45 * 60;

        int calcSecond = total - minusSecond;
        int calcHour = calcSecond / 3600;
        if(calcHour == 24) calcHour = 0;
        int calcMinute = calcSecond % 3600 / 60;
        System.out.print(calcHour);
        System.out.print(" " + calcMinute);
    }
    public static int getTotalSecond(int hour, int minute) {
        int total = 0;
        if(hour == 0) hour = 24;
        total += hour * 3600;
        total += minute * 60;
        return total;
    }
}