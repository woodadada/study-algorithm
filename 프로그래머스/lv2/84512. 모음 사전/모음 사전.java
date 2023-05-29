import java.util.*;
import java.util.stream.Collectors;
class Solution {
    static Set<String> set = new HashSet<>();
    static String[] arr = {"", "A", "E", "I", "O", "U"};

    public int solution(String word) {

        recursive(5,"");
        ArrayList<String> arr = new ArrayList<>(set);
        Collections.sort(arr);

        return arr.indexOf(word);
    }

    public void recursive(int n, String str) {
        if(n == 0){
            set.add(str);
            return;
        }
        for(int i = 0; i < 6; i++){
            recursive(n - 1, str + arr[i]);
        }
    }
}