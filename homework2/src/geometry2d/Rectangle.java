package geometry2d;

import exceptions.InvalidDimensionException;

public class Rectangle implements Figure {
    private double width, height;

    public Rectangle(double width, double height) throws InvalidDimensionException {
        if (width <= 0 || height <= 0) {
            throw  new InvalidDimensionException("Ширина и высота должны быть положительными");
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public double area(){
        return width * height;
    }

    @Override
    public double perimeter(){
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "Прямоугольник " + width + "x" + height + ", площадь: " + area() + ", периметр: " + perimeter();
    }
}
