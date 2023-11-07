import java.util.*;
class Solution {
    public String solution(String my_string, int[] index_list) {
        StringBuilder sb = new StringBuilder();
        String[] strArr = my_string.split("");
        for (int i : index_list) {
            sb.append(strArr[i]);
        }
        
        return sb.toString();
    }
}