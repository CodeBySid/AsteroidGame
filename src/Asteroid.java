import javax.swing.*;
import java.util.Random;

class Asteroid extends JLabel {
    private int curX, curY;
    private Random r = new Random();
    private int width = 110, height = 95;
    private ImageIcon asteroid = new ImageIcon("res/NewAsteroid.gif");

    //Get random Position
    public Asteroid(GameState game) {
        curX = r.nextInt(game.getWidth() - 120);
        curY = game.getY();
        setIcon(asteroid);
        setBounds(curX, curY, width, height);
    }

    public void plusY() {
        curY++;
    }

    public int gety() {
        return curY;
    }

    public int getx() {
        return curX;
    }

}
