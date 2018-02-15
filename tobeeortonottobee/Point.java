public class Point {
    public int x, y, z;

    public Point() {
        x = 0;
        y = 0;
        z = 0;
    }
    public Point(int xi, int yi, int zi) {
        x = xi;
        y = yi;
        z = zi;
    }

    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
