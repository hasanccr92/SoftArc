public class Rectangle implements Comparable<Rectangle> {
    double width;
    double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double calculateArea() {
        return width * height;
    }

    @Override
    public int compareTo(Rectangle other) {
        // Compare by area
        return Double.compare(this.calculateArea(), other.calculateArea());
    }

    public void printRectangle() {
        System.out.println("Rectangle [width=" + width + ", height=" + height + ", area=" + calculateArea() + "]");
    }
}
