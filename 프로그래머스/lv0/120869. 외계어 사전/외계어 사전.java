class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        
        for (int i = 0; i < dic.length; i++) {
            if(dic[i].length() < spell.length){
                dic[i] += "*".repeat(spell.length - dic[i].length());
            }
            for (String s1 : spell) {
                dic[i] = dic[i].replaceFirst(s1, "");
            }
        }
        
        for (int i = 0; i < dic.length; i++) {
            if(dic[i].equals("")){
                answer = 1;
                break;
            }
        }
        return answer;
    }
}