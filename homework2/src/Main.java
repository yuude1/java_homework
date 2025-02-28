import java.util.Scanner;
import geometry2d.Circle;
import geometry2d.Rectangle;
import geometry3d.Cylinder;
import exceptions.InvalidDimensionException;
import exceptions.NegativeHeightException;

public class Main {
    public static void main(String[] args) {
        Button button = new Button();
        button.click(); // 1
        button.click(); // 2

        Balance balance = new Balance();
        balance.addLeft();
        balance.addRigth();
        balance.result();

        Bell bell = new Bell();
        bell.sound();
        System.out.println("");

        OddEvenSeparator oddEven = new OddEvenSeparator();
        for(int i = 0; i < 10; i++){
            oddEven.addNumber();
            oddEven.numbers();
        }
        oddEven.Even();
        oddEven.Odd();

        Table table = new Table(3,3);
        table.setValue(2,2,1);
        table.setValue(0,0,2);
        table.setValue(0,1,3);
        table.setValue(0,2,4);
        table.setValue(1,0,5);
        table.setValue(1,1,6);
        table.setValue(1,2,7);
        table.setValue(2,0,8);
        table.setValue(2,1,9);
        System.out.println("Значение в (3,3): " + table.getValue(2, 2));
        System.out.println("Таблица:\n" + table);
        System.out.println("Число строк: " + table.rows());
        System.out.println("Число столбцов: " + table.cols());
        System.out.println("Среднее арифметическое: " + table.average());

        try {
            Circle circle = new Circle(5);
            Rectangle rectangle = new Rectangle(4,6);
            Cylinder cylinder = new Cylinder(circle, 10);

            System.out.println(circle);
            System.out.println(rectangle);
            System.out.println(cylinder);
        } catch (InvalidDimensionException | NegativeHeightException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}