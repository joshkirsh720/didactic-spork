public class Space {

    private Point location;

    public Space(int x, int y, int z) {
        location = new Point(x, y, z);
    }

    public int getX() {
        return location.x;
    }
    public int getY() {
        return location.y;
    }
    public int getZ() {
        return location.z;
    }

    public Point getParent() {
        return location.parent;
    }
    public void setParent(Point p) {
        location.parent = p;
    }

    protected void setLocation(int xi, int yi, int zi) {
        location.x = xi;
        location.y = yi;
        location.z = zi;
    }

    public String toString() {
        return location.toString();
    }
}
