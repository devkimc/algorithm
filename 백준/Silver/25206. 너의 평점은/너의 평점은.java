import java.util.*;

public class Main {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int totalCredit = 0;
        float totalScore = 0;

        for (int i = 0; i < 20; i++) {
            String line = sc.nextLine();
            String[] strings = line.split(" ");

            if ("P".equals(strings[2])) continue;

            int credit = (int) Float.parseFloat(strings[1]);
            float score = getScoreOfGrade(strings[2]);

            totalCredit += credit;
            totalScore += credit * score;
        }

        System.out.println(totalScore / totalCredit);
    }

    private static float getScoreOfGrade(String grade) {
        switch (grade) {
            case "A+":
                return 4.5F;
            case "A0":
                return 4.0F;
            case "B+":
                return 3.5F;
            case "B0":
                return 3.0F;
            case "C+":
                return 2.5F;
            case "C0":
                return 2.0F;
            case "D+":
                return 1.5F;
            case "D0":
                return 1.0F;
            case "F":
                return 0;
        }

        return 0;
    }
}