import java.util.Scanner;

public class BackIn30Minutes_04 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int hours=Integer.parseInt(scanner.nextLine());
        int minutes=Integer.parseInt(scanner.nextLine());

        int allMinutes=(hours*60)+minutes+30;
        int hoursRes=allMinutes/60;
        int  minRes=allMinutes%60;

        if (hoursRes > 23){
            hoursRes=0;
        }

        System.out.printf("%d:%02d",hoursRes,minRes);

    }
}
