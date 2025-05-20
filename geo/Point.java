package geo;

public class Point {
    int x, y;

    public Point(int a, int b) {
        this.x = a;
        this.y = b;
    }

    public Point() {
    }

    /******************************************************************************************************************************/

    public int setX(int nw) {
        return this.x = nw;
    }

    public int setY(int nw) {
        return this.y = nw;
    }

    public void setPoint(int a, int b) {
        this.x = a;
        this.y = b;
    }

    /******************************************************************************************************************************/

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    /******************************************************************************************************************************/

}