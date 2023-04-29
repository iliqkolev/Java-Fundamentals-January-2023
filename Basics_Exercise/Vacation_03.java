import java.util.Scanner;

public class Vacation_03 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        String kind = scanner.nextLine();
        String day = scanner.nextLine();
        double price = 0.0;
        double discount = 0.0;
        if (kind.equals("Students")) {
            switch (day) {
                case "Friday":
                    price = 8.45;
                    break;
                case "Saturday":
                    price = 9.80;
                    break;
                case "Sunday":
                    price = 10.46;
                    break;
            }
            if (number >= 30) {
                discount = 0.15;
            }

        } else if (kind.equals("Business")) {
            switch (day) {
                case "Friday":
                    price = 10.90;
                    break;
                case "Saturday":
                    price = 15.60;
                    break;
                case "Sunday":
                    price = 16.00;
                    break;
            }
            if (number >= 100) {
                number -= 10;
            }
        } else if (kind.equals("Regular")) {
            switch (day) {
                case "Friday":
                    price = 15.00;
                    break;
                case "Saturday":
                    price = 20.00;
                    break;
                case "Sunday":
                    price = 22.50;
                    break;
            }
            if (number >= 10 && number <= 20) {
                discount = 0.05;
            }
        }
        System.out.printf("Total price: %.2f", (price * number) - (price * discount * number));
    }
}
