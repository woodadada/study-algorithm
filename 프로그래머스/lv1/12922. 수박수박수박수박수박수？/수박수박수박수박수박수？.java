class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int i = n / 2;
        if(n % 2 == 0){
            for (int j = 0; j < i; j++) {
                sb.append("수박");
            }
        }else{
            for (int j = 0; j < i; j++) {
                sb.append("수박");
            }
            sb.append("수");
        }
        
        return sb.toString();
    }
}