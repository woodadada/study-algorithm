
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int solution(int[] bandage, int health, int[][] attacks) {
        // bandage 시전 시간, 초당 회복량, 추가 회복량
        // health 체력
        // attacks 공격 시간, 피해량
        int time = bandage[0];
        int recovery = bandage[1];
        int bonusRecovery = bandage[2];
        int lastAttackTime = attacks[attacks.length - 1][0];

        // 공격 시간, 피해량 map에 저장
        Map<Integer, Integer> attacksMap = new HashMap<>();
        Arrays.stream(attacks).forEach(arr -> {
            attacksMap.put(arr[0], arr[1]);
        });

        int count = 0;
        int nowHealth = health;
        for (int i = 1; i <= lastAttackTime; i++) {

            boolean attackFlag = attacksMap.containsKey(i);
            Integer damage = attacksMap.get(i);

            // 공격 받지 않으면 연속 회복 카운트 상승
            if (!attackFlag) {
                count++;

                // 보너스 체력 회복 획득 여부 확인
                if (count == time) {
                    nowHealth += bonusRecovery;
                    count = 0;
                }

                // 체력 회복
                nowHealth += recovery;

                // 회복 후 체력이 최대 체력이 넘는지 확인
                if(nowHealth > health) nowHealth = health;

            } else { // 공격 받음
                count = 0; // 연속 회복 카운트 초기화

                nowHealth -= damage;

                if(nowHealth <= 0) break;
            }
        }

        int answer = nowHealth <= 0 ? -1 : nowHealth;
        return answer;
    }
}