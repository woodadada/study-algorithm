
import java.util.HashMap;
import java.util.Map;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> map = new HashMap<>();
        int[] answer = new int[targets.length];

        for (int i = 0; i < keymap.length; i++) {
            String s = keymap[i];
            for (char c : s.toCharArray()) {
                int i1 = s.indexOf(c) + 1;
                Integer orDefault = map.getOrDefault(c, 100);
                if(i1 < orDefault){
                    map.put(c, i1);
                }
            }
        }

        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            for (char c : target.toCharArray()) {
                if(map.containsKey(c)){
                    answer[i] += map.get(c);
                }else{
                    answer[i] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}