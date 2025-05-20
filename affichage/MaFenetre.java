package affichage;

import geo.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import terrain.Terrain;

public class MaFenetre extends JFrame implements KeyListener {

   Terrain terrain;

   public MaFenetre(Terrain terrain) {
      this.terrain = terrain;
      setTitle("Snake");
      setSize(600, 600);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      addKeyListener(this);

      add(terrain);

      setVisible(true);
   }

   @Override
   public void keyTyped(KeyEvent e) {
      // Control of the snake 
      switch (e.getKeyChar()) {
         case 'w':
            this.terrain.getSnake().setDp(new Point(0, -19));
            break;
         case 's':
            this.terrain.getSnake().setDp(new Point(0, 19));
            break;
         case 'a':
            this.terrain.getSnake().setDp(new Point(-19, 0));
            break;
         case 'd':
            this.terrain.getSnake().setDp(new Point(19, 0));
            break;
      }
   }

   @Override
   public void keyPressed(KeyEvent e) {
     // System.out.println(e.getKeyChar());
   }

   @Override
   public void keyReleased(KeyEvent e) {
    //  System.out.println(e.getKeyChar());
   }

}
