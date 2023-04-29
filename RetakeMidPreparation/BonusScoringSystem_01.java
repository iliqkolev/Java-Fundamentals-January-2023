package MidExam_5;

import java.util.Scanner;

public class BonusScoringSystem_01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int numberOfStudents=Integer.parseInt(scanner.nextLine());
        int lectures=Integer.parseInt(scanner.nextLine());
        int additionalBonus=Integer.parseInt(scanner.nextLine());
        double maxBonus=0;
        double maxAtt=0;

        for (int i = 1; i <= numberOfStudents ; i++) {
            int attendances=Integer.parseInt(scanner.nextLine());
            double bonus=(1.0*attendances/lectures)*(5+additionalBonus);


            if (bonus >= maxBonus){
                maxBonus=bonus;
                maxAtt=attendances;
            }
        }
        System.out.printf("Max Bonus: %.0f.\n", Math.ceil(maxBonus));
        System.out.printf("The student has attended %.0f lectures.\n", maxAtt);
    }
}
