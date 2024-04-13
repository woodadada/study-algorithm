import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double scoreSum = 0;
        double sum = 0;

        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            String strScore = st.nextToken();
            String grade = st.nextToken();

            if(!grade.equals("P")) { // P 제외 모두 집계
                double score = Double.parseDouble(strScore);
                double gradeScore = getGradeScore(grade);
                scoreSum += score;
                sum += score * gradeScore;
            }
        }
        System.out.println(sum / scoreSum);
    }

    static double getGradeScore(String grade) {
        double result = 0;
        switch (grade) {
            case "A+" :
                result = 4.5;
                break;
            case "A0" :
                result = 4;
                break;
            case "B+" :
                result = 3.5;
                break;
            case "B0" :
                result = 3;
                break;
            case "C+" :
                result = 2.5;
                break;
            case "C0" :
                result = 2;
                break;
            case "D+" :
                result = 1.5;
                break;
            case "D0" :
                result = 1;
                break;
            case "F" :
                result = 0;
                break;
        }
        return result;
    }
}