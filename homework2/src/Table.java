import java.util.ArrayList;

public class Table {
    private int[][] data;

    public Table(int rows, int cols) {
        data = new int[rows][cols];
    }

    public int getValue(int row, int col) {
        return data[row][col];
    }

    // Установка значения в ячейку
    public void setValue(int row, int col, int value) {
        data[row][col] = value;
    }

    // Получение количества строк
    public int rows() {
        return data.length;
    }

    // Получение количества столбцов
    public int cols() {
        return data[0].length;
    }

    public double average(){
        int sum = 0;
        int count = 0;
        for(int[] row : data){
            for(int num : row){
                sum += num;
                count++;
            }
        }
        return sum/count;
    }



    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(int[] row : data) {
            for(int num : row) {
                str.append(num).append("\t");
            }
            str.append("\n");
        }
        return str.toString();
    }
}
