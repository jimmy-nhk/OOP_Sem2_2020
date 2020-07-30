package Wk5;


public class Test {
    public static void main(String[] args) {
        Triangle t = new Triangle(3,4,5, "BLUE",true);
        System.out.println("The area is " +t.getArea());
        System.out.println("The perimeter is " +t.getPerimeter());
        System.out.println(t.getColor());
        System.out.println(t.isFilled());

        Triangle t2 = new Triangle(4,4,5, "BLUE",true);
        if (Triangle.max(t,t2)) {
            System.out.println(t.toString());
        } else
            System.out.println(t2.toString());
    }
}
