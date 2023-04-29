import java.util.Scanner;

public class Ages_01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int num=Integer.parseInt(scanner.nextLine());

        if ( num >= 0 && num <=2){
            System.out.println("baby");
        }else if(num >= 3 && num <= 13){
            System.out.println("child");
        } else if (num >= 14 && num <=19) {
            System.out.println("teenager");
        } else if (num >= 20 && num <=65) {
            System.out.println("adult");
        }else{
            System.out.println("elder");
        }
    }
}
