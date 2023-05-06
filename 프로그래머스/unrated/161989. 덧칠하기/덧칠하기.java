class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int max = section[0] + m;
        for (int i = 0; i < section.length; i++) {
            if(max <= section[i]) {
                answer++;
                max = section[i] + m;
            } else {
                continue;
            }
        }
        System.out.println("answer = " + answer);
        return answer;
    }
}