import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      Scanner scanner=new Scanner(System.in);

      String input=scanner.nextLine();
      int number=Integer.parseInt(scanner.nextLine());
      String []array=input.split(" ");

        for (int i = 1; i <= number ; i++) {
            String firstElement=array[0];
            for (int j = 0; j < array.length - 1; j++) {
                array[j]=array[j + 1];
            }
            array[array.length - 1]=firstElement;
        }
        for (String elements:array) {
            System.out.print(elements + " ");
        }
    }
}