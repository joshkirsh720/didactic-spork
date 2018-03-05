public class Point {
    public int x, y, z;
    public Point parent;

    public Point() {
        x = 0;
        y = 0;
        z = 0;
        parent = null;
    }
    public Point(int xi, int yi, int zi) {
        x = xi;
        y = yi;
        z = zi;
    }
    public Point(int xi, int yi, int zi, Point p) {
        x = xi;
        y = yi;
        z = zi;
        parent = p;
    }

    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
