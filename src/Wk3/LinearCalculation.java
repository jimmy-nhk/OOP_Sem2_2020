package Wk3;

import java.util.Scanner;

public class LinearCalculation {
    public static void main ( String [] args ) {

        System.out.println("Enter the linear equation :") ;
        Scanner in = new Scanner(System.in) ;
        double a = in.nextDouble() ;
        double b = in.nextDouble() ;
        double c = in.nextDouble() ;
        double d = in.nextDouble() ;
        double e = in.nextDouble() ;
        double f = in.nextDouble() ;
        LinearEquation A = new LinearEquation(a , b , c ,d, e , f) ;


        if (A.isSolvable()) {
            System.out.println("x is " + A.getX() +
                    " and y is " + A.getY()) ;
        } else
            System.out.println("The equation has no solution.") ;


    }
}

class LinearEquation {
    private double a , b , c , d ,e , f ;

    public LinearEquation ( double a , double b , double c , double d , double e , double f) {
        this.a = a ;
        this.b = b ;
        this.c = c ;
        this.d = d ;
        this.e = e ;
        this.f = f ;
    }

    public double getA() {
        return this.a ;
    }

    public double getB() {
        return this.b ;
    }

    public double getC() {
        return this.c ;
    }

    public double getD() {
        return this.d ;
    }

    public double getE() {
        return this.e ;
    }

    public double getF() {
        return this.f ;
    }

    public boolean isSolvable () {
         if ((this.a * this.d - this.b * this.c) != 0 )
             return true ;
         else
             return false ;
    }

    public double getX () {
        double a = this.e * this.d - this.b * this.f ;
        double b = this.a * this.d - this.b * this.c ;
        return a/b ;
    }

    public double getY () {
        double a = this.a * this.f - this.e * this.c ;
        double b = this.a * this.d - this.b * this.c ;
        return a/b ;
    }

}