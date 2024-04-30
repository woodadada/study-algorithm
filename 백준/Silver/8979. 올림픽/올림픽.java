import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 입력 국가 수
        int k = Integer.parseInt(st.nextToken()); // 순위 알고 싶은 국가

        List<Rank> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int country = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            Rank rank = new Rank(country, gold, silver, bronze, 1);
            list.add(rank);
        }

        Collections.sort(list, new Rank());
        int targetIdx = 0;
        for (int i = 1; i < n; i++) {
            Rank now = list.get(i);
            Rank temp = list.get(i - 1);

            if(now.country == k) targetIdx = i;
            
            if(now.gold == temp.gold
                    && now.silver == temp.silver
                    && now.bronze == temp.bronze) {
                now.rate = temp.rate;
            } else {
                now.rate = i + 1;
            }
        }
        System.out.println(list.get(targetIdx).rate);

    }

    public static class Rank implements Comparator<Rank> {
        int country;
        int gold;
        int silver;
        int bronze;
        int rate;

        public Rank() {}

        public Rank(int country, int gold, int silver, int bronze, int rate) {
            this.country = country;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
            this.rate = rate;
        }

        @Override
        public int compare(Rank o1, Rank o2) {
            // 금메달
            if(o1.gold == o2.gold) {
                if(o1.silver == o2.silver) {
                    return o2.bronze - o1.bronze;
                } else {
                    return o2.silver - o1.silver;
                }
            } else {
                return o2.gold - o1.gold;
            }
        }
    }
}