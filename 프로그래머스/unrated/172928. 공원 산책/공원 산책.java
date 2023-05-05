import java.util.Arrays;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] start = new int[2];
        // 시작 지점 찾기
        for (int i = 0; i < park.length; i++) {
            String s = park[i];
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        System.out.println("Arrays.toString(start) = " + Arrays.toString(start));
        for (int i = 0; i < routes.length; i++) {
            char op = routes[i].charAt(0); // 이동 방향
            int n = Character.getNumericValue(routes[i].charAt(2)); // 이동할 칸 수
            boolean flag = true;

            if(op == 'E') { // 동
                if(start[1] + n >= park[0].length()) continue;
                for (int j = 1; j <= n; j++) {
                    if(park[start[0]].charAt(start[1] + j) == 'X') {
                        flag = false;
                        break;
                    }
                }
                if(flag) start[1] = start[1] + n;
            } else if (op == 'W') { // 서
                if(start[1] - n < 0) continue;
                for (int j = 1; j <= n; j++) {
                    if(park[start[0]].charAt(start[1] - j) == 'X') {
                        flag = false;
                        break;
                    }
                }
                if(flag) start[1] = start[1] - n;
            } else if (op == 'S') { // 남
                if(start[0] + n >= park.length) continue;
                for (int j = 1; j <= n; j++) {
                    if(park[start[0] + j].charAt(start[1]) == 'X') {
                        flag = false;
                        break;
                    }
                }
                if(flag) start[0] = start[0] + n;
            } else { // 북
                if(start[0] - n < 0) continue;
                for (int j = 1; j <= n; j++) {
                    if(park[start[0] - j].charAt(start[1]) == 'X') {
                        flag = false;
                        break;
                    }
                }
                if(flag) start[0] = start[0] - n;
            }
            System.out.println("Arrays.toString(start) = " + Arrays.toString(start));
        }
        return start;
    }
}