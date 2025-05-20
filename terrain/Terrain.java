package terrain;

import geo.Point;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import nourriture.Nourriture;
import serpent.Snake;

// The playground :

public class Terrain extends JPanel {
    Snake snake;

    // Size of the snake hitbox (rectangle)

    int len = 18;

    // Score count
    int point = 0;

    // Size of the snake body part
    int len2 = 20;

    Nourriture pomme = new Nourriture(200, 200);

    Random rand = new Random();

    public Terrain(Snake s) {
        this.snake = s;
        // Redraw the scene every "x" millisecond
        Timer timer = new Timer(100, e -> {

            // move the snake
            this.snake.seDeplacer();
            if (this.point > 0) {
                // verify if he bite himself
                this.mordu();
            }
            // verify if he ate an apple
            this.eatApple();

            // verify if pass enter in contact with the frame/panel limit
            this.heurterMur();

            repaint();
        });
        timer.start();
    }
    
    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Snake getSnake() {
        return snake;
    }

    public void eatApple() {
        // verify if he ate the apple
        if (this.getSnake().getHead().intersects(pomme)) {
            // generating a new apple 
            pomme.x = rand.nextInt(this.getWidth());
            pomme.y = rand.nextInt(this.getHeight());
            // adding point
            this.point++;

            // the snake grows
            this.getSnake().getBody().allonger(new Rectangle(this.getSnake().getBody().lastPart().x,
                    this.getSnake().getBody().lastPart().y, this.len, this.len));
        }
    }

    public void mordu() {
        // verify if he enters in contact with himself 
        for (Rectangle corp : this.snake.getBody().getCorp()) {
            if (this.snake.getHead().intersects(corp)) {
                // make him immobile
                this.snake.setDp(new Point(0, 0));

                // show an error pane 
                // PS : fix this after bcs i can't close the frame anymore ( need to close the frame to start a new game )
                JOptionPane.showMessageDialog(this, snake, " Game over ", 0);
            }
        }
    }

    public void heurterMur() {
        if (this.snake.getHead().x >= this.getWidth()) {
            this.snake.getHead().x = 1;
        }

        if (this.snake.getHead().x <= 0) {
            this.snake.getHead().x = this.getWidth();
        }

        if (this.snake.getHead().y >= this.getHeight()) {
            this.snake.getHead().y = 1;
        }

        if (this.snake.getHead().y <= 0) {
            this.snake.getHead().y = this.getHeight();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        // draw all part of the snake 
        g2d.fillRect(this.snake.getHead().getPosition().getX(), this.snake.getHead().getPosition().getY(), this.len,
                this.len);
        for (Rectangle corp : this.snake.getBody().getCorp()) {
            g2d.fillRect(corp.x, corp.y, len, len);
            this.snake.getBody().getCorp().size();
        }

        // draw the food
        g2d.setColor(Color.RED);
        g2d.fillRect(this.pomme.x, this.pomme.y, this.len2, this.len2);
    }
}