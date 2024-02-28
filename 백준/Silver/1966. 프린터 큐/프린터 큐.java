import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 총 테스트 횟수
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            int count = Integer.parseInt(split[0]);
            int target = Integer.parseInt(split[1]);

            Queue<Print> queue = new LinkedList<>();
            // 우선순위 max알기 위해 초기화
            int[] arr = new int[count];
            // 프린터 개수
            String[] prints = br.readLine().split(" ");
            for (int j = 0; j < count; j++) {
                int priority = Integer.parseInt(prints[j]);
                arr[j] = priority;
                Print print = new Print(priority, j);
                queue.add(print);
            }
            Arrays.sort(arr);

            int maxIndex = arr.length - 1;
            int max = arr[maxIndex];
            int answer = 0;
            while (true) {
                Print peek = queue.peek();
                if (peek.getPriority() == max) { // 우선순위가 상위면 poll, max 초기화
                    queue.poll();
                    answer++;
                    if (queue.isEmpty()) break;
                    max = arr[--maxIndex];

                    if(peek.getOrder() == target) break; // 프린트 순서를 알고 싶은 타겟 확인
                } else { // 우선순위가 상위가 아니면 가장 뒤로
                    queue.offer(queue.poll());
                }
            }
            System.out.println(answer);
        }
    }

    public static class Print{

        int priority;
        int order;


        public Print() {
        }

        public Print(int priority, int order) {
            this.priority = priority;
            this.order = order;
        }

        public int getPriority() {
            return priority;
        }

        public int getOrder() {
            return order;
        }

    }
}