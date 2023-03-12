class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int bonus = 0, count = 0;

        for (int lotto : lottos) {
            if(lotto == 0){
                bonus++;
            }
        }
        for (int win_num : win_nums) {
            for (int lotto : lottos) {
                if(win_num == lotto) {
                    count++;
                }
            }
        }
        if(count == 0 && bonus == 0){
            count++;
        } else if(count == 0) {
            count++;
            bonus--;
        }

        return new int[] {(7 - (count + bonus)), (7 - count)};
    }
}