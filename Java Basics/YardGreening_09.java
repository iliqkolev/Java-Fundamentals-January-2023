import java.util.Scanner;

public class YardGreening_09 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        double kvm=Double.parseDouble(scanner.nextLine());
        double theWholeYard= kvm*7.61;
        double Discount=theWholeYard*0.18;
        double endSum= theWholeYard-Discount;
        System.out.println("The final price is: "+ endSum+ " lv.");
        System.out.println("Discount is: "+ Discount+ " lv.");
    }
}
