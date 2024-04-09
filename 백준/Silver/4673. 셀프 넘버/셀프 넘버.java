public class Main {
    public static void main(String[] args) {
        int n = 10001;
        boolean[] check = new boolean[n];
        for (int i = 1; i < n; i++) {
            int num = go(i);
            if(num < n) {
                check[num] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            if(!check[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
    static int go(int num) {
        int sum = num;

        while(num != 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}