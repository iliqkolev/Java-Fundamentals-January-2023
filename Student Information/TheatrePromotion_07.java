import java.util.Scanner;

public class TheatrePromotion_07 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String dayOfTheWeek=scanner.nextLine();
        int age=Integer.parseInt(scanner.nextLine());

        switch (dayOfTheWeek){
            case "Weekday":
                if (age >=0 && age <= 18){
                    System.out.println("12$");
                    break;
                }else if (age > 18 && age <=64 ){
                    System.out.println("18$");
                    break;
                }else if (age > 64 && age <= 122){
                    System.out.println("12$");
                    break;
                }

            case "Weekend":
                if (age >=0 && age <= 18){
                    System.out.println("15$");
                    break;
                }else if (age > 18 && age <=64 ){
                    System.out.println("20$");
                    break;
                }else if (age > 64 && age <= 122){
                    System.out.println("15$");
                    break;
                }

            case "Holiday":
                if (age >=0 && age <= 18){
                    System.out.println("5$");
                    break;
                }else if (age > 18 && age <=64 ){
                    System.out.println("12$");
                    break;
                }else if (age > 64 && age <= 122){
                    System.out.println("10$");
                    break;
                }
            default:
                System.out.println("Error!");
                break;
        }

    }
}
