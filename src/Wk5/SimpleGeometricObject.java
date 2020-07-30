package Wk5;

import java.util.Date;

public abstract class SimpleGeometricObject implements Comparable <SimpleGeometricObject> {
    private String color = "white";
    private boolean filled = false;
    private Date dateCreated = new Date();

    /**
     * Construct a default geometric object
     */
    public SimpleGeometricObject() {
    }

    /**
     * Construct a geometric object with the specified color and filled value
     */
    public SimpleGeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    /**
     * Return color
     */
    public String getColor() {
        return color;
    }

    /**
     * Set a new color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Return filled. Since filled is boolean, its get method is named isFilled
     */
    public boolean isFilled() {
        return filled;
    }

    /**
     * Set a new filled
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /**
     * Get dateCreated
     */
    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    /**
     * Return a string representation of this object
     */
    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
    }

    @Override
    public  int compareTo(SimpleGeometricObject o){
        if (this.getArea() > o.getArea())
            return 1 ;
        else if (this.getArea() == o.getArea())
            return 0;
        else
            return -1;
    }

    public static boolean max ( SimpleGeometricObject o1 , SimpleGeometricObject o2){
        if (o1.compareTo(o2) >= 0 ) {
            return true;
        } else
            return false;
    }

    public abstract double getArea ();



}
