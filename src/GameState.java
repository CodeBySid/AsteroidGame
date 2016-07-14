
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class GameState extends JPanel
{
    Spaceship ship;
    ArrayList Asteroids= new ArrayList();
    private int LaserStart;
    GameState temp;
    Scoreboard scoreb =new Scoreboard(SpaceShip);
    private static int SpaceShip, SpaceLaser, map, listselectgame;

    public GameState()
    {
        setBounds(0,25,1100,575);

        if(map == 0){
            setBackground(Color.darkGray);
        }else if (map == 1){
            setBackground(Color.white);
        }else if(map == 2){
            setBackground(Color.red);
        }
        else if(map == 3){
            setBackground(Color.YELLOW);
        }
        else if(map == 4){
            setBackground(Color.GRAY);
        }
        setLayout(null);

        addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {

            }
            // two handler
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==e.VK_SPACE)
                    ShootLaser();
            }
            public void keyPressed(KeyEvent e) {
                ship.keyPressed(e);
            }
        });
    }
    public void addscoreboard(){ getParent().add(scoreb);}


    public static void main(String[] args, int SpaceType, int SpaceLaserw, int map1, String name, int listselect)
    {
        listselectgame = listselect;
        SpaceShip = SpaceType;
        SpaceLaser = SpaceLaserw;
        map =map1;
        JFrame GameFrame= new JFrame("Asteroid game");
        GameFrame.getContentPane().setLayout(null);
        GameState AstroGame= new GameState();

        GameFrame.setBounds(120,40, 1100, 600);
        GameFrame.setResizable(false);
        GameFrame.setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );

        AstroGame.AddSpaceship();
        GameFrame.add(AstroGame);
        AstroGame.addscoreboard();
        GameFrame.getContentPane().repaint();
        AstroGame.repaint();
        GameFrame.setVisible(true);
        AstroGame.requestFocus();
        AstroGame.CreateAstro();


    }
    public void AddSpaceship ()
    {
        ship= new Spaceship(this, SpaceShip);
        add(ship);
    }
    public void ShootLaser()
    {
        LaserStart=ship.getX();
        Thread laserthread = new Thread()
        {
            public void run(){
                Laser FireLaser = new Laser(LaserStart+58,ship.getY(),SpaceLaser);
                add(FireLaser);
                outerloop:
                while (true)
                {
                    FireLaser.minusy();
                    try{sleep(3);}catch(Exception e){}
                    FireLaser.setLocation(LaserStart,FireLaser.gety());

                    for ( int i=0;i<Asteroids.size();i++)
                    {
                        Asteroid a=(Asteroid)Asteroids.get(i);
                        if (FireLaser.getBounds().intersects(a.getBounds()))
                        {
                            scoreb.add();
                            remove(a);
                            Asteroids.remove(a);
                            remove(FireLaser);
                            repaint();
                            break outerloop;
                        }
                    }
                    if (FireLaser.gety()<getY())
                    {remove(FireLaser);
                        repaint();
                        break;}
                }
            }
        };
        laserthread.start();
    }
    public void CreateAstro()
    {
        temp=this;

        int speed1;

        if(listselectgame == 0){
            speed1 = 10 ;
            CreateAstroThread CreateAstro = new CreateAstroThread(speed1);
            CreateAstro.start();
        }else if (listselectgame == 1){
            speed1 = 8 ;
            CreateAstroThread CreateAstro = new CreateAstroThread(speed1);
            CreateAstro.start();
        }else if(listselectgame == 2){
            speed1 = 6 ;
            CreateAstroThread CreateAstro = new CreateAstroThread(speed1);
            CreateAstro.start();
        }
        else if(listselectgame == 3){
            speed1 = 4 ;
            CreateAstroThread CreateAstro = new CreateAstroThread(speed1);
            CreateAstro.start();
        }
        else if(listselectgame == 4){
            speed1 = 2 ;
            CreateAstroThread CreateAstro = new CreateAstroThread(speed1);
            CreateAstro.start();
        }


    }
    class CreateAstroThread extends Thread{

        private int speed;
        public CreateAstroThread(int speed) {
            this.speed = speed;
        }
        public void run()
        {
            while (true)
            {
                int speed2 =speed;
                AstroThread Astro= new AstroThread(speed2);
                Astro.start();
                try {sleep(750);}catch (Exception e){}
            }
        }
    }

    class AstroThread extends Thread{
        private int speed;
        public AstroThread(int speed) {
            this.speed = speed;
        }

        public void run()
        {
            Asteroid astro = new Asteroid(temp);
            temp.add(astro);
            Asteroids.add(astro);

            while (true)
            {
                int speed =this.speed;
                astro.plusY();
                astro.setLocation(astro.getx(), astro.gety());
                System.out.println(speed);
                try {sleep(speed);} catch(Exception e){}
                if (astro.gety()>temp.getHeight()-70)
                {remove(astro);
                    Asteroids.remove(astro);
                    repaint();
                    break;}
                if (astro.getBounds().intersects(ship.getBounds()))
                {
                    scoreb.minus();
                    remove(astro);
                    Asteroids.remove(astro);
                    repaint();
                    break;
                }
            }
        }
    }

}
