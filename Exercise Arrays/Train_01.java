import java.util.Scanner;

public class Train_01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());

        int[] peopleInVagoon=new int[n];
        int sum=0;

        for (int i = 0; i < n ; i++) {
            peopleInVagoon[i]=Integer.parseInt(scanner.nextLine());
            System.out.println(peopleInVagoon[i] + " ");
            sum+=peopleInVagoon[i];
        }
        System.out.printf("%n%d",sum);


    }
}
