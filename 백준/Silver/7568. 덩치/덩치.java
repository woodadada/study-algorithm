import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        List<Physical> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Physical(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for (int i = 0; i < list.size(); i++) {
            Physical basePhysical = list.get(i);
            for (int j = 0; j < list.size(); j++) {
                if(i != j) {
                    Physical target = list.get(j);
                    boolean weightFlag = false;
                    boolean heightFlag = false;
                    if(basePhysical.getWeight() < target.getWeight()) {
                        weightFlag = true;
                    }

                    if(basePhysical.getHeight() < target.getHeight()) {
                        heightFlag = true;
                    }

                    if(weightFlag && heightFlag) {
                        basePhysical.updateOrder();
                    }
                }
            }
            System.out.println(basePhysical.getOrder());
        }
    }

    public static class Physical {
        int weight;
        int height;
        int order = 1;

        public Physical(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        public int getWeight() {
            return weight;
        }

        public int getHeight() {
            return height;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public void updateOrder() {
            this.order++;
        }

        @Override
        public String toString() {
            return "Physical{" +
                    "weight=" + weight +
                    ", height=" + height +
                    ", order=" + order +
                    '}';
        }
    }
}