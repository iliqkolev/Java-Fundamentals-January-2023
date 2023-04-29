import java.util.Scanner;

public class exercise_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sizeOfSide = Integer.parseInt(scanner.nextLine());
        int sheets = Integer.parseInt(scanner.nextLine());
        double areaSheets = 0;
        double singleSheet= 0;

        double sizeOfSideSum = sizeOfSide * sizeOfSide * 6;
        for (int i = 1; i <= sheets; i++) {
            double lengthSheet = Double.parseDouble(scanner.nextLine());
            double widthSheet = Double.parseDouble(scanner.nextLine());

            singleSheet=lengthSheet*widthSheet;
            areaSheets += singleSheet;


            if (i % 3 == 0) {
                double third=singleSheet * 0.25;
                areaSheets -= third;
            }
            if (i % 5 == 0) {
                double fifth=lengthSheet*widthSheet;
                areaSheets -= fifth;
            }
        }

        if (areaSheets > sizeOfSideSum){
            double percent=((areaSheets-sizeOfSideSum)/areaSheets)*100;
            System.out.println("You've covered the gift box!");
            System.out.printf("%.2f%% wrap paper left.", percent);
        }else if (areaSheets <= sizeOfSideSum){
            double totalAreaCovered=(areaSheets/sizeOfSideSum)*100;
            double percent=100-totalAreaCovered;
            System.out.println("You are out of paper!");
            System.out.printf("%.2f%% of the box is not covered.", percent);
        }
    }
}
