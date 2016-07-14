import javax.swing.*;
import java.awt.*;

class Scoreboard extends JPanel {
    private JTextField scoretracker, lifetracker;
    int life, score = 0;
    private int SpaceshipTypehere;
    public Scoreboard(int SpaceshipType) {

        SpaceshipTypehere = SpaceshipType;
        if(SpaceshipTypehere == 0){
            life = 10;
        }else if (SpaceshipTypehere == 1){
            life= 15;
        }else if(SpaceshipTypehere == 2){
            life= 20;
        }
        else if(SpaceshipTypehere == 3){
            life= 5;
        }
        else if(SpaceshipTypehere == 4){
            life = 30;
        }

        setBounds(0, 0, 550, 25);
        scoretracker = new JTextField("" + score, 5);
        scoretracker.setFont(new Font("Arial", Font.PLAIN, 14));
        scoretracker.setEditable(false);
        lifetracker = new JTextField("" + life, 5);
        lifetracker.setFont(new Font("Arial", Font.PLAIN, 14));
        lifetracker.setEditable(false);
        add(scoretracker);
        add(lifetracker);
    }

    public int getscore() {
        return score;
    }

    public int getlife() {
        return life;
    }

    public void add() {
        if(SpaceshipTypehere == 0){
            score++;
        }else if (SpaceshipTypehere == 1){
            score = score + 2;
        }else if(SpaceshipTypehere == 2){
            score = score + 3;
        }
        else if(SpaceshipTypehere == 3){
            score = score + 10;
        }
        else if(SpaceshipTypehere == 4){
            score = score + 2;
        }
        scoretracker.setText("" + score);
    }

    public void minus() {
        life--;
        lifetracker.setText("" + life);
        if (life == 0) {
            JOptionPane.showMessageDialog(this, "You made: " + score, "Game Over!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

}