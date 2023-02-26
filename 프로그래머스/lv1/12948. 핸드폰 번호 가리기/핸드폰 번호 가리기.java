class Solution {
    public String solution(String phone_number) {
        int length = phone_number.length() - 4;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < phone_number.length(); i++) {
            if(i < length){
                sb.append("*");
            }else{
                sb.append(phone_number.charAt(i));
            }
        }
        return sb.toString();
    }
}