import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = -1;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.add(i);
        }
        
        int count = 0;
        // 처음부터 통과되는 경우
        if(pq.peek() >= K) {
            return count;
        }
        
        while(!pq.isEmpty()) {
            int a = pq.poll();
            
            if(pq.isEmpty()) {
                return answer;
            }
            
            int b = pq.poll();
            pq.offer(a + (b * 2));
            count++;
            
            if(K <= pq.peek()) {
                return count;
            }
        }

        return answer;
    }
}