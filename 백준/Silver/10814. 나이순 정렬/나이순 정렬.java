import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {

        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(br.readLine());
        List<User> users = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            User user = new User(j, Integer.parseInt(st.nextToken()), st.nextToken());
            users.add(user);
        }

        Collections.sort(users, new User());

        StringBuilder sb = new StringBuilder();
        for (User user : users) {
            user.getAge();
            sb.append(user.getAge()).append(" ").append(user.getName()).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static class User implements Comparator<User>{
        int no;
        int age;
        String name;

        public User() {
        }

        public User(int no, int age, String name) {
            this.no = no;
            this.age = age;
            this.name = name;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int compare(User u1, User u2) {
            // 먼저 age를 기준으로 비교
            int ageCompare = u1.getAge() - u2.getAge();
            if (ageCompare != 0) {
                return ageCompare;
            }
            // age가 같을 경우에는 no를 기준으로 비교
            return u1.getNo() - u2.getNo();
        }
    }
}