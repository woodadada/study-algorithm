class Solution {
    public int[] solution(long n) {
        String s = String.valueOf(n);
        int[] answer = new int[s.length()];
        String[] split = s.split("");
        for (int i = 0; i < split.length; i++) {
            answer[i] = Integer.valueOf(split[split.length - 1 - i]);
        }
        return answer;
    }
}