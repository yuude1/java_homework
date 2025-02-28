import java.util.Scanner;
import java.util.ArrayList;

public class Balance {
    private int right, left;
    private Scanner scanner;

    public Balance() {
        this.scanner = new Scanner(System.in);
    }

    public void addRigth() {
        System.out.print("Enter Right Value: ");
        right = scanner.nextInt();
    }

    public void addLeft() {
        System.out.print("Enter Left Value: ");
        left = scanner.nextInt();
    }

    public void result() {
        if (left == right) {
            System.out.println("=");
        } else if (left > right) {
            System.out.println("L");
        } else {
            System.out.println("R");
        }
    }

    public void closeScanner() {
        scanner.close();
    }
}
