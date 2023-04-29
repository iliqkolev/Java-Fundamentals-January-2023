package MidExamRetake_6;

import java.util.Scanner;

public class BlackFlag_01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        //колко дни продължава пиратството
        int days=Integer.parseInt(scanner.nextLine());
        //колко плячка имат за един ден
        int plunderForDay=Integer.parseInt(scanner.nextLine());
        //очаквана плячка в края
        int expectedPlunder=Integer.parseInt(scanner.nextLine());
        //сума на плячката
        double plunderSum=0;


        for (int day = 1; day <= days; day++) {
            plunderSum += plunderForDay;

            if (day % 3 == 0){
                double additionalPlunder=plunderForDay * 0.5;
                plunderSum += additionalPlunder;
            }
            if (day % 5 == 0) {
                    plunderSum = plunderSum -(0.3*plunderSum);
            }
        }
            if (plunderSum >= expectedPlunder){
                System.out.printf("Ahoy! %.2f plunder gained.", plunderSum);
            }else{
                double percent=(plunderSum/expectedPlunder) * 100;
                System.out.printf("Collected only %.2f%% of the plunder.",percent);
            }
    }
}
