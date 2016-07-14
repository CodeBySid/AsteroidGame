import javax.swing.*;

class Laser extends JLabel
{
    private int curX , curY   ;
    private int width = 149,  height = 156;

    private ImageIcon laser=new ImageIcon("res/Laser.png");
    private ImageIcon laserbig=new ImageIcon("res/LaserBig.png");
    private ImageIcon laserlong=new ImageIcon("res/LaserLong.png");
    private ImageIcon lasermed=new ImageIcon("res/LaserMediium.png");
    private ImageIcon lasersmall=new ImageIcon("res/LaserSmall.png");
    ImageIcon[] array = {lasersmall,laser,lasermed,laserlong,laserbig };

    public Laser(int x, int y, int laser)
    {
        curX=x; curY=y;
        setIcon(this.array[laser]);
        setBounds(curX,curY,width,height);
    }
    public void minusy(){
        curY--;
    }
    public int gety(){
        return curY;
    }

}
