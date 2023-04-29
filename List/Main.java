
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.*;

public class Main {
    public static  void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

//        List<Integer> numbers=  new ArrayList<>(Arrays.asList(5,11,1,34,3));
//        Collections.sort(numbers);
//        Collections.reverse(numbers);
//        System.out.println(numbers.toString());

//        int n=10;
//        int num=Integer.parseInt(scanner.nextLine());
//
//        for (int i = 10; i >= n - num; i--) {
//            System.out.println(i);
//        }

        List<String> names= Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        int number=Integer.parseInt(scanner.nextLine());

        for (int i = names.size() ; i > names.size() -number ; i--) {
            System.out.println(i);
        }
    }
}