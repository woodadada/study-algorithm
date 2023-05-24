import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        // 오름차순 정렬
        Arrays.sort(people);
        int lt = 0;
        int rt = people.length - 1;

        // two pointer
        while(lt <= rt) {
            // 다 돌고도 보트에 한명만 탈 수 있는 경우
            if(lt == rt) {
                answer++;
                break;
            }
            // 두명이 탈 수 있는 경우
            if(limit >= people[lt] + people[rt]) {
                answer++;
                lt++;
                rt--;
            } else { // rt index 먼저 보트에 태우는 경우
                answer++;
                rt--;
            }
        }

        return answer;
    }
}