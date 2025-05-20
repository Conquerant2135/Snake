package serpent;

import geo.Point;
import java.awt.Rectangle;

public class Tete extends Rectangle {
    
    // Rectangle for easier collision handling

    public Tete(int x, int y){
        super(x , y , 18 , 18);
    }

    public void setPosition(int x, int y){
        this.setLocation( x , y );
    }

    public Point getPosition(){
        return new Point(this.x , this.y);
    }
}