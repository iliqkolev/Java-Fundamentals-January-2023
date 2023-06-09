package MidExamRetake_3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShootForTheWin_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] targets = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String command = scanner.nextLine();
        int shotTargets = 0;

        while (!"End".equals(command)) {
            int index = Integer.parseInt(command);
            if (index >= 0 && index < targets.length && targets[index] != -1) {
                shotTargets++;
                int currentNumber = targets[index];
                targets[index] = -1;
                for (int i = 0; i < targets.length; i++) {
                    if (targets[i] != -1 && targets[i] <= currentNumber) {
                        targets[i] = targets[i] + currentNumber;
                    } else if (targets[i] != -1 && targets[i] > currentNumber) {
                        targets[i] = targets[i] - currentNumber;
                    }
                }
            }
            command = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", shotTargets);
        for (int target : targets) {
            System.out.print(target + " ");
        }
    }
}

