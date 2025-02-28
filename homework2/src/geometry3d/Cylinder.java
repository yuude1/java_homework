package geometry3d;

import geometry2d.Figure;
import exceptions.NegativeHeightException;

public class Cylinder {
    private Figure base;
    private double height;

    public Cylinder(Figure base, double height) throws NegativeHeightException {
        if (height <= 0) {
            throw new NegativeHeightException("Высота цилиндра должна быть положительной");
        }
        this.base = base;
        this.height = height;
    }

    public double volume(){
        return base.area()*height;
    }

    @Override
    public String toString() {
        return "Цилиндр с основанием (" + base.toString() + ") и высотой " + height + ", объем: " + volume();
    }
}
