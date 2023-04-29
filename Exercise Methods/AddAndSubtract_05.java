import java.util.Scanner;

public class AddAndSubtract_05 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int first=Integer.parseInt(scanner.nextLine());
        int second=Integer.parseInt(scanner.nextLine());
        int third=Integer.parseInt(scanner.nextLine());

        printSum(first,second,third);
    }
    public static void printSum(int first,int second,int third){
       int sum=(first+second)-third;
        System.out.println(sum);
    }
}
