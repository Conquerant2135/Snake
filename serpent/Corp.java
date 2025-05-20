package serpent;

import java.awt.Rectangle;
import java.util.Vector;

public class Corp {
    Vector<Rectangle> corp;

    public void allonger(Rectangle r) {
        if (corp == null) {
            corp = new Vector<Rectangle>();
        }

        // add another part to the snake

        this.corp.add(r);
    }

    public Vector<Rectangle> getCorp() {
        return corp;
    }

    public Rectangle lastPart() {
        return this.corp.lastElement();
    }
}