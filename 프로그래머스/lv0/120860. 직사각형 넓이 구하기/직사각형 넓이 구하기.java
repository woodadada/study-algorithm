class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        
        int maxX = -256, minX = 256;
        int maxY = -256, minY = 256;
        for (int i = 0; i < dots.length; i++) {
            int[] dot = dots[i];
//            System.out.println("dot = " + Arrays.toString(dot));
//            System.out.println("dot[0] = " + dot[0]);
            maxX = Math.max(dot[0], maxX);
            minX = Math.min(dot[0], minX);
            maxY = Math.max(dot[1], maxY);
            minY = Math.min(dot[1], minY);
        }
        answer = (maxX - minX) * (maxY - minY);
        return answer;
    }
}