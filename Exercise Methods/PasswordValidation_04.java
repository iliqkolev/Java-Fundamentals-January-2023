import java.util.Scanner;

public class PasswordValidation_04 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String password=scanner.nextLine();


        //1. proverim dali daljinata  na parolata e validna
        boolean isValidLength=isValidLength(password);
            if (!isValidLength){
                System.out.println("Password must be between 6 and 10 characters");
            }


        //2.proverim sadarjanieto
            boolean isValidContent=isValidContent(password);
            if (!isValidContent){
                System.out.println("Password must consist only of letters and digits");
            }


        //3. proverim dali broi na cifrite e validen
            boolean isValidCountDigits=isValidCountDigits(password);
            if (!isValidCountDigits){
                System.out.println("Password must have at least 2 digits");
            }

        //4. proverqvame dali cqlostno e validna parolata
        if (isValidLength && isValidContent && isValidCountDigits){
            System.out.println("Password is valid");
        }

    }
    public static boolean isValidLength(String password){
        return password.length() >= 6 && password.length() <= 10;
    }
    public static boolean isValidContent(String password){
        //password = "login".toCharArray() -> ['l' 'o' 'g' 'i' 'n']
        for (char symbol:password.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol)){
                return false;
            }
        }
        return true;
    }
    public static boolean isValidCountDigits(String password){
        int countDigits=0;
        //password= "Pesho123"
        for (char symbol: password.toCharArray()) {
            if (Character.isDigit(symbol)){
                //isDigit
                //true -> ako symbol e cifra
                //false -> symbol ne e cifra
                countDigits++;
            }
        }
        //true-> broi >= 2
        //false -> broi < 2
        return countDigits >= 2;

    }
}
