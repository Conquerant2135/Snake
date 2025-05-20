package serpent;

import geo.Point;
import java.awt.*;
import java.util.Vector;

public class Snake {
    Tete head;

    Corp body;

    int len = 19;

    Point dp = new Point(0, 0);

    public Snake(int x, int y) {
        head = new Tete(x, y);
        body = new Corp();
        body.allonger(new Rectangle(x, y, len, len));
    }

    /******************************************************************************************************************************/

    public void setHead(Tete head) {
        this.head = head;
    }

    public void setBody(Corp body) {
        this.body = body;
    }

    public void setDp(Point p) {
        this.dp = p;
    }


    /******************************************************************************************************************************/

    public Tete getHead() {
        return head;
    }

    public Corp getBody() {
        return body;
    }

    /******************************************************************************************************************************/

    public void seDeplacer() {
        // Copy the body previous position

        Vector<Rectangle> oldVect = new Vector<>();
        for (Rectangle r : this.body.getCorp()) {
            oldVect.add(new Rectangle(r));
        }

        //Move the head and save his old position

        Point oldPos = new Point(this.getHead().x, this.getHead().y);
        this.getHead().setPosition(this.getHead().x + this.dp.getX(), this.getHead().y + this.dp.getY());

        // The 1st part of the body take the old position of the head

        this.body.getCorp().get(0).setLocation(oldPos.getX(), oldPos.getY());

        if (this.body.getCorp().size() <= 1) {
            return;
        }

        // The body take the position of the previous part 

        for (int i = 1; i < this.body.getCorp().size(); i++) {
            this.body.getCorp().get(i).setLocation(oldVect.get(i - 1).getLocation());
        }
    }
}
