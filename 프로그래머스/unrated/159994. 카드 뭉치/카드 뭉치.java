import java.util.Arrays;
import java.util.List;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < goal.length; i++) {
            String s = goal[i];
            if(index1 < cards1.length && s.equals(cards1[index1])){
                index1++;
            }else if(index2 < cards2.length && s.equals(cards2[index2])){
                index2++;
            }else{
                return "No";
            }
        }
        return "Yes";
    }
}