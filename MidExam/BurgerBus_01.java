import java.util.Scanner;

public class BurgerBus_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int citiesCount = Integer.parseInt(scanner.nextLine());

        double sum = 0;
        double totalSum=0;

        for (int index = 1; index <= citiesCount; index++) {
            String cityName = scanner.nextLine();
            double income = Double.parseDouble(scanner.nextLine());
            double expenses = Double.parseDouble(scanner.nextLine());



            if (index % 5 == 0) {
                income = income - (income * 0.1);
            } else if (index % 3 == 0) {
                expenses = expenses + (expenses * 0.5);
            }
            sum = income - expenses;
            totalSum += sum;

            System.out.printf("In %s Burger Bus earned %.2f leva.\n", cityName, sum);

        }
        System.out.printf("Burger Bus total profit: %.2f leva.", totalSum);
    }
}
