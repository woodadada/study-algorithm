class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int bonus = 0, count = 0;

        for (int lotto : lottos) {
            if(lotto == 0){
                bonus++;
            }
            for (int win_num : win_nums) {
                if(lotto == win_num) {
                    count++;
                }
            }
        }

        int high = count + bonus;
        int row = count;

        return new int[] {Math.min(7 - high, 6), Math.min(7 - row, 6)};
    }
}