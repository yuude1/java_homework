import java.util.Scanner;
import java.util.ArrayList;

public class OddEvenSeparator {
    private int num;
    private Scanner scanner;
    ArrayList<Integer> odd = new ArrayList<>();
    ArrayList<Integer> even = new ArrayList<>();

    public OddEvenSeparator() {
        this.scanner = new Scanner(System.in);
    }
    public void addNumber(){
        System.out.print("Enter a number: ");
        num = scanner.nextInt();
    }

    public void numbers(){
        if (num % 2 == 0) {
            even.add(num);
        }
        else{
            odd.add(num);
        }
    }

    public void Even() {
        System.out.println(even);
    }
    public void Odd() {
        System.out.println(odd);
    }

    public void closeScanner() {
        scanner.close();
    }

}
