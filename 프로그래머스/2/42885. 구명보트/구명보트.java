import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        // 오름차순 정렬
        Arrays.sort(people);
        int min = 0;
        int max = people.length - 1;
        while (min <= max) {
            if(people[min] + people[max] <= limit) {
                answer++;
                min++;
                max--;
            } else if(min == max) {
                answer++;
                break;
            } else {
                answer++;
                max--;
            }
        }
        return answer;
    }
}