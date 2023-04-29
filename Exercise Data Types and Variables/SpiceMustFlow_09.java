import java.util.Scanner;

public class SpiceMustFlow_09 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int yield=Integer.parseInt(scanner.nextLine());
        int days=0;
        int spicesAmount=0;

        while (yield >= 100){
            int spices=yield-26;
            spicesAmount+=spices;
            days++;
            yield -= 10;
        }

        System.out.println(days);
        if (spicesAmount >= 26){
            spicesAmount -=26;
        }
        System.out.println(spicesAmount);




    }
}
