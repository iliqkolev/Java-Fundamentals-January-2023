import java.util.Scanner;

public class ValidUsernames_01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String[] usernamesArr=scanner.nextLine().split(", ");

        for (String username: usernamesArr){
            if (isValidUsername(username)){
                System.out.println(username);
            }
        }

    }
    private static boolean isValidUsername(String username){
        //1.Валидна дължина
        //[3, 16]-> валидна
        if (username.length() < 3 || username.length() > 16){
            //невалидна дължина-> невалиден username
            return false;
        }
        //дължина е валидна-> [3, 16]

        //2. валидно съдържание -> букви,цифри,-,_
        //username="TestUser".toCharArray()-> ['T', 'e', 's', 't', 'U', 's', 'e', 'r']
        for (char symbol: username.toCharArray()){
             if (!Character.isLetterOrDigit(symbol) && symbol != '-' && symbol != '_'){
                    return  false;
             }
        }
        //валидно съдържание
        return true;
    }
}
