import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainApplication extends JFrame {

    private static String name;
    private javax.swing.JCheckBox tb0, tb1, tb2, tb3, tb4;
    private javax.swing.JLabel Spaceship, label;
    private javax.swing.JComboBox BackColor;

    private javax.swing.JScrollPane js;

    private JPanel contentpane;
    private int frameWidth = 1200, frameHeight = 700, shipWidth = 322, shipHeight = 455, shipCurX = 550, shipCurY = -90;
    private ButtonGroup bgroup;
    private String[] avatarImg = {"res/t1.png", "res/t2.png", "res/t3.png", "res/t4.png", "res/t5.png"};
    private JTextField Name;
    private String name1;
    private int ShipType, Shiplaser, Map;
    JList list;

    public String getName() {
        return name1;
    }

    public MainApplication() {
        name = "Sid";
        setTitle("Menu_app");
        setBounds(12, 12, frameWidth, frameHeight);
        setResizable(false);
        setLocationRelativeTo(null);
        contentpane = (JPanel) getContentPane();
        contentpane.setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {

        Icon icon = new ImageIcon(avatarImg[0]);
        Spaceship = new javax.swing.JLabel();
        Spaceship.setBounds(shipCurX, shipCurY, shipWidth, shipHeight);
        Spaceship.setIcon(icon);
        js = new JScrollPane();

        label = new JLabel();
        label.setText("Enter Name: ");
        label.setBounds(400, 300, 200, 50);
        Name = new JTextField();
        Name.setBounds(500, 315, 90, 24);
        System.out.println();


        bgroup = new ButtonGroup();
        tb0 = new JCheckBox("Spaceship 1");
        tb1 = new JCheckBox("Spaceship 2");
        tb2 = new JCheckBox("Spaceship 3");
        tb3 = new JCheckBox("Spaceship 4");
        tb4 = new JCheckBox("Spaceship 5");
        tb0.setSelected(true);

        tb0.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (tb0.isSelected()) Spaceship.setIcon(new ImageIcon(avatarImg[0]));
                Spaceship.setBounds(shipCurX, shipCurY, shipWidth, shipHeight);
                ShipType = 0;
                Shiplaser = 0;
            }
        });
        tb1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (tb1.isSelected()) Spaceship.setIcon(new ImageIcon(avatarImg[1]));
                Spaceship.setBounds(shipCurX, shipCurY, shipWidth, shipHeight);
                ShipType = 1;
                Shiplaser = 1;
            }
        });
        tb2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (tb2.isSelected()) Spaceship.setIcon(new ImageIcon(avatarImg[2]));
                Spaceship.setBounds(shipCurX, shipCurY, shipWidth, shipHeight);
                ShipType = 2;
                Shiplaser = 2;
            }
        });
        tb3.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (tb3.isSelected()) Spaceship.setIcon(new ImageIcon(avatarImg[3]));
                Spaceship.setBounds(shipCurX, shipCurY, shipWidth, shipHeight);
                ShipType = 3;
                Shiplaser = 3;
            }
        });
        tb4.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (tb4.isSelected()) Spaceship.setIcon(new ImageIcon(avatarImg[4]));
                Spaceship.setBounds(shipCurX, shipCurY, shipWidth, shipHeight);
                ShipType = 4;
            Shiplaser = 4;
        }
        });

        bgroup.add(tb0);
        bgroup.add(tb1);
        bgroup.add(tb2);
        bgroup.add(tb3);
        bgroup.add(tb4);

        String[] comboOptions = {"Dark Grey", "White", "Red", "Yellow", "Grey"};

        BackColor = new JComboBox(comboOptions);
        BackColor.setToolTipText("Select Background Color");
        BackColor.setSelectedIndex(0);
        contentpane.setBackground(Color.white);
        BackColor.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int index = BackColor.getSelectedIndex();
                if (index == 0) Map = 0;
                if (index == 1) Map = 1;
                if (index == 2) Map = 2;
                if (index == 3) Map = 3;
                if (index == 4) Map = 4;
            }
        });

        final JButton AstroGameStart = new JButton("GO!");
        //One Handler

        String[] Difficulty = {"Very Easy", "Easy", "Medium", "Hard", "Very Hard"};
        list = new JList(Difficulty);
        list.setSelectedIndex(0);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JPanel JList = new JPanel();
        JList.setBounds(600, 500, 100, 100);
        JList.add(list);
        contentpane.add(JList);

        AstroGameStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int listselect = list.getSelectedIndex();
                String str = Name.getText();
                GameState.main(avatarImg, ShipType, Shiplaser, Map, str, listselect);
            }
        });

        AstroGameStart.setBounds(400, 550, 100, 25);

        JPanel Choice = new JPanel();
        Choice.setBounds(400, 400, 400, 100);
        Choice.add(tb0);
        Choice.add(tb1);
        Choice.add(tb2);
        Choice.add(tb3);
        Choice.add(tb4);

        JPanel namegroup = new JPanel();
        namegroup.setBounds(400, 300, 50, 100);
        namegroup.add(label);
        namegroup.add(Name);

        JPanel DropDown = new JPanel();
        DropDown.setBounds(400, 500, 100, 33);
        DropDown.add(BackColor);

        //handler
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(null, "Thank You For Playing " + Name.getText(), "", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        contentpane.add(Name);
        contentpane.add(label);
        contentpane.add(DropDown);
        contentpane.add(AstroGameStart);
        contentpane.add(Choice);
        contentpane.add(Spaceship);

    }

    public static void main(String args[]) {
        new GameState();
        new MainApplication();
    }


}
