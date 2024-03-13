import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        List<Point> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add( new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) );
        }
        list.sort(new Point());

        for (Point point : list) {
            System.out.println(point.getX() + " " + point.getY());
        }
    }

    public static class Point implements Comparator<Point> {
        int x;
        int y;

        public Point(){};
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public int compare(Point o1, Point o2) {
            int i = o1.getY() - o2.getY(); // y먼저 오름차순
            if(i != 0) {
                return i;
            } else { // y가 같다면 x 순으로 정렬
                return o1.getX() - o2.getX();
            }
        }
    }
}