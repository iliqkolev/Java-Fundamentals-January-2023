import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            prinetMinNumber();

    }

    public static void prinetMinNumber() {
            Scanner scanner=new Scanner(System.in);

            int a=Integer.parseInt(scanner.nextLine());
            int b=Integer.parseInt(scanner.nextLine());

        if (a < b){
            System.out.println(a);
        }else{
            System.out.println(b);
        }
    }
}