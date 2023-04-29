import java.util.Scanner;

public class Projects_Creation_07 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String name=scanner.nextLine();
        int projects=Integer.parseInt(scanner.nextLine());
        int sumProjects=projects*3;
        System.out.println("The architect "+name+ " will need "+ sumProjects+ " hours to complete "+projects+" project/s. ");
    }
}
