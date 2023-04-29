import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        List<Integer> number=new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        List<Integer> removeNum=new ArrayList<>(Arrays.asList(3,4));

        number.retainAll(removeNum);
        System.out.println();

    }
}