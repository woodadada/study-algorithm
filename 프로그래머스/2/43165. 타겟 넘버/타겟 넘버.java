import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public static int solution(int[] numbers, int target) {
        int bfs = bfs(numbers, target);

        return bfs;
    }

    public static int bfs(int[] numbers, int target) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        int index = 0;
        int sum = 0;
        queue.offer(new int[] {index, sum + numbers[index]});
        queue.offer(new int[] {index, sum - numbers[index]});

        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            index = node[0];
            sum = node[1];

            if(index == numbers.length - 1) {
                if(sum == target) {
                    count++;
                }
                continue;
            }

            index++;
            queue.offer(new int[] {index, sum + numbers[index]});
            queue.offer(new int[] {index, sum - numbers[index]});
        }
        return count;
    }
}