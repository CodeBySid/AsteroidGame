import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Spaceship extends JLabel implements KeyListener
{
    private int curX  = 100, curY   ;
    private int width = 200,  height = 248;
    private ImageIcon SpaceshipDefault, SpaceshipBlue, SpaceshipBlack, SpaceshipRedR, SpaceshipRed ;

    public Spaceship(GameState game, int shipNumber)
    {
        SpaceshipDefault = new ImageIcon("res/t1.png");
        SpaceshipBlue = new ImageIcon("res/t2.png");
        SpaceshipBlack = new ImageIcon("res/t3.png");
        SpaceshipRedR = new ImageIcon("res/t4.png");
        SpaceshipRed = new ImageIcon("res/t5.png");
        ImageIcon[] array = {SpaceshipDefault,SpaceshipBlue,SpaceshipBlack,SpaceshipRedR,SpaceshipRed };
        setIcon(array[shipNumber]);
        curY=game.getHeight()-height-20;
        setBounds(curX, curY, width, height);
    }


    public void keyPressed(KeyEvent e)       {

        if (e.getKeyCode()==e.VK_LEFT)
        {
            if (curX>getParent().getX()-50)
            {curX-=10;
                setLocation(curX,curY);}
        }
        if (e.getKeyCode()==e.VK_RIGHT)
        {
            if (curX<getParent().getWidth()-70){
                curX+=10;
                setLocation(curX,curY);}
        }
        if (e.getKeyCode()==e.VK_UP)
        {
            if (curY>getParent().getHeight()+getHeight()){
                curY-=10;
                setLocation(curX,curY);}
        }
        if (e.getKeyCode()==e.VK_DOWN)
        {
            if (curY>getParent().getHeight()-70){
                curY+=10;
                setLocation(curX,curY);}
        }
    }
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    public int getX(){return curX;}
    public int getY(){return curY;}


}
