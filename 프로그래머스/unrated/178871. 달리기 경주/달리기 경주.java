import java.util.HashMap;
import java.util.Map;
class Solution {
    public String[] solution(String[] players, String[] callings) {
     
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String calling : callings) {
            Integer index = map.get(calling);
            map.put(calling, index - 1);
            // 앞 선수
            String player = players[index - 1];
            map.put(player, index);
            swap(players, index);
        }
        return players;
    }
    
    public void swap(String[] players, int index) {
        String temp = players[index];
        players[index] = players[index - 1];
        players[index - 1] = temp;
    }
}