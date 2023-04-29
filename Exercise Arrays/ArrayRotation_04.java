import java.util.Scanner;

public class ArrayRotation_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int countRotations = Integer.parseInt(scan.nextLine());

        String[] array = input.split(" ");

        for (int i = 1; i <= countRotations; i++) {
            //1. взимам първия елемент
            String firstElement = array[0];
            //2.премествам елементите наляво
            for (int j = 0; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }
            //3. поставям първия елемент на последно място
            array[array.length - 1]=firstElement;
        }
        //приключваме с ротациите
        for (String element :array) {
            System.out.print(element + " ");
        }

    }
}
