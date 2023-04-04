import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> nameMap = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            nameMap.put(name[i], yearning[i]);
        }

        int[] result = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            String[] strings = photo[i];
            
            for (int j = 0; j < strings.length; j++) {
                if(nameMap.containsKey(strings[j])){
                    result[i] += nameMap.get(strings[j]);
                }
            }
        }
        
        return result;
    }
}