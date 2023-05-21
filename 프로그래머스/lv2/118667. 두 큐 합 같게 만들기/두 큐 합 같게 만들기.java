import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long total = 0;
        long sum1 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        // array to queue and sum
        for (int i = 0; i < queue1.length; i++) {
            total += queue1[i];
            sum1 += queue1[i];
            total += queue2[i];
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }
        if(total / 2 == 1) return -1;
        // queue half
        long half = total / 2;
        int poll;
        while(sum1 != half) {
            if(sum1 < half){
                poll = q2.poll();
                q1.offer(poll);
                sum1 += poll;
            } else {
                poll = q1.poll();
                q2.offer(poll);
                sum1 -= poll;
            }
            answer++;
            
            if(answer > queue1.length * 4) return -1;
        }
        return answer;
    }               
}