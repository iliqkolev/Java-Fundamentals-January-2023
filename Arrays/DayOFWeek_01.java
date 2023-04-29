import java.util.Scanner;

public class DayOFWeek_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        String[] dayOFWeekArr = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        };
        if (n >=1 && n <=7){
            System.out.println(dayOFWeekArr[n - 1]);
        }else{
            System.out.println("Invalid day!");
        }



    }
}
