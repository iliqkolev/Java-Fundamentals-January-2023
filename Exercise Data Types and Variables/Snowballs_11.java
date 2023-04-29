import java.util.Scanner;

public class Snowballs_11 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int countBalls=Integer.parseInt(scanner.nextLine());
        double maxSnowBallValue=Double.MIN_VALUE;
        int maxSnowballSnow=Integer.MIN_VALUE;
        int maxSnowballTime=Integer.MIN_VALUE;
        int maxSnowballQuality=Integer.MIN_VALUE;


        for (int i = 1; i <= countBalls; i++) {
            int snowballSnow=Integer.parseInt(scanner.nextLine());
            int snowballTime=Integer.parseInt(scanner.nextLine());
            int snowballQuality=Integer.parseInt(scanner.nextLine());

            double snowballValue=Math.pow(snowballSnow/snowballTime,snowballQuality);

            if (snowballValue > maxSnowBallValue){
                maxSnowBallValue=snowballValue;
                maxSnowballSnow=snowballSnow;
                maxSnowballTime=snowballTime;
                maxSnowballQuality=snowballQuality;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)",maxSnowballSnow,maxSnowballTime,maxSnowBallValue,maxSnowballQuality);
    }
}
