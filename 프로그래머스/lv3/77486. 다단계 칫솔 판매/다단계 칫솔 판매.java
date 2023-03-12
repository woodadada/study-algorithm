import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        Map<String, String> parentMap = new HashMap<>(); // <본인, 부모>
        Map<String, Integer> childMap = new HashMap<>(); // <본인, 본인 순서>

        for (int i = 0; i < enroll.length; i++) {
            parentMap.put(enroll[i], referral[i]);
            childMap.put(enroll[i], i);
        }

        for (int i = 0; i < seller.length; i++) {

            String s = seller[i];
            int profit = 100 * amount[i]; // 판매 수익

            while(!s.equals("-")){
                int profitForParent = profit / 10; // 상납 금액
                int nowProfit = profit - profitForParent; // 본인이 가질 금액

                answer[childMap.get(s)] += nowProfit;
                
                s = parentMap.get(s); // 부모 노드로 이동
                profit /= 10;
                
                if(profit < 1){ // 상납할 금액은 1원 이상만 가능
                    break;
                }
            }
        }
        return answer;
    }
}