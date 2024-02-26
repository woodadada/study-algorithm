import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            Point point = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            points.add(point);
        }
        Collections.sort(points, new Point());


        StringBuilder sb = new StringBuilder();
        for (Point point : points) {
            sb.append(point.getX()).append(" ").append(point.getY()).append("\n");
        }

        System.out.println(sb.toString());

    }

    public static class Point implements Comparator<Point> {
        int x;
        int y;
        
        public Point() {}

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
            int xCompare = o1.getX() - o2.getX();

            if(xCompare != 0) {
                return xCompare;
            }
            return o1.getY() - o2.getY();
        }
    }
}