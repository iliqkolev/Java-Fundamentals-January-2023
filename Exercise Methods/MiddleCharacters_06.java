import java.util.Scanner;

public class MiddleCharacters_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        printMiddleCharacter(text);
    }

    public static void printMiddleCharacter(String text) {

        //нечетна дължина -> 1 символ
        if (text.length() % 2 != 0) {
            int indexMiddle = text.length() / 2;
            System.out.println(text.charAt(indexMiddle));
        }
        //четна дължина -> 2символа
        else {
            int indexFirstMiddle = text.length() / 2 - 1;
            int indexSecondMiddle = text.length() / 2;

            System.out.print(text.charAt(indexFirstMiddle));
            System.out.print(text.charAt(indexSecondMiddle));
        }


    }
}
