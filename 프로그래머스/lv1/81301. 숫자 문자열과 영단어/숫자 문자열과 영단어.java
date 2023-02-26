import java.util.HashMap;
import java.util.Map;
class Solution {
    public int solution(String s) {
        int answer = 0;

        Map<String, String> map = new HashMap<>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
//            System.out.println("c = " + c);
            String substring = s.substring(i, s.length());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if(substring.startsWith(entry.getKey())){
                    sb.append(entry.getValue());
                    i += entry.getValue().length() + 1;
                }
            }
//            System.out.println("substring = " + substring);
            if(Character.isDigit(c)){
                sb.append(c);
            }

        }
//        System.out.println("sb.toString() = " + sb.toString());

        answer = Integer.valueOf(sb.toString());
        
        return answer;
    }
}