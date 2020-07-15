package Wk3;

public class TestRectangle {

    public static void main(String[] args) {

        Rectangle r1 = new Rectangle(4.0, 40);
        System.out.println(r1.toString());
        System.out.println("The area of r1 rectangle is " + r1.getArea());
        System.out.println("The perimeter of r1 rectangle is " + r1.getPerimeter());

        System.out.println();
        Rectangle r2 = new Rectangle(3.5, 35.9);
        System.out.println(r2.toString());
        System.out.printf("The area of rectangle is %.2f \n", r2.getArea());
        System.out.printf("The perimeter of rectangle is  %.2f ", r2.getPerimeter());

    }

}

class Rectangle {
    static double width = 1;
    static double height = 1;

    public Rectangle(double v, double v1) {
        this.width = v;
        this.height = v1;
    }

    public double getArea() {
        return (this.width * this.height);
    }

    public double getPerimeter() {
        return (2 * (this.width + this.height));
    }

    public String toString() {
        return "The width of the rectangle is : " + this.width + "\n" +
                "The height of the rectangle is : " + this.height;
    }
}
