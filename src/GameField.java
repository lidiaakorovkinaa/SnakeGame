import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.awt.*;
import javax.swing.*;
public class GameField extends JPanel implements ActionListener {
    //поля
    private int snakePositionX=272;
    private Timer timer;
    private int applePositionX =200;
    private int applePositionY =205;
    private JFrame frame = new JFrame();


    //игровое поле
    public GameField() {
        setBackground(new java.awt.Color(134, 157, 235, 255));
        JLabel label = new JLabel("       SNAKE GAME       ");
        label.setFont(new Font("Serif", Font.PLAIN, 28));
        JButton start = new JButton("Start!");
        start.setBackground(Color.lightGray);
        JButton stop = new JButton("Stop!");
        stop.setBackground(Color.lightGray);
        frame.setLocation(400,400);
        //расположение кнопок+линия
        JPanel  panels = new JPanel();
        panels.setLayout(new FlowLayout());
        JPanel  line = new JPanel();
        line.setBackground(Color.white);
        line.setLayout(new GridLayout(1,1));


        //надпись
        JPanel menu = new JPanel();
        menu.setBackground(new java.awt.Color(211, 215, 217, 153));
        menu.setLayout(new GridLayout(1,1));
        //вся панель
        JPanel  field = new JPanel();
        field.setLayout(new GridLayout(7,1));
        field.setOpaque(false);
        field.setBorder(BorderFactory.createMatteBorder(4, 4, 30, 4, Color.WHITE));
        field.add(menu);
        field.add(line);
        //линия к панели
        line.add(panels);
        //кнопки к панели
        panels.add(start);
        panels.add(stop);
        //надпись к меню
        menu.add(label);
        //меню,и линия к главной панели
        add(field);
        //кнопка start
        start.addActionListener(e -> initGame());
        //кнопка stop
        stop.addActionListener(e -> stop());
    }
    //в игре
    public void initGame() {
            timer = new Timer(250, this);
            timer.start();
            ApplePosition();
    }
    public void stop() {
               timer.stop();
    }

    public void ApplePosition() {
        applePositionX = (int) (15+Math.random()*200);
        applePositionY = (int) (85+Math.random()*160);
    }


    @Override
    protected void paintComponent(Graphics g) {
       super.paintComponent(g);
        g.setColor(new java.awt.Color(31, 54, 4, 153));
        int snakePositionY = 249;
        g.fillRect(snakePositionX, snakePositionY, 16, 16);
        g.setColor(new java.awt.Color(150, 22, 37, 255));
        g.fillOval(applePositionX, applePositionY, 16, 16);
    }




    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        boolean inGame = true;
        if (inGame) {
           if(snakePositionX<274) {
               snakePositionX++;
               repaint();
           }else{
               stop();
               JOptionPane.showMessageDialog(frame,"YOU ARE DEAD!");
           }


        }


    }

}