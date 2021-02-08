import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameField extends JPanel implements ActionListener {
    private final JFrame frame = new JFrame();
    private int appleX = 400;
    private int appleY = 400;
    private int snakeX = 40;
    private int snakeY = 340;
    private Timer timer;
    private boolean moveUp = false;
    private boolean moveLeft = false;
    private boolean moveRight = false;
    private boolean moveDown = false;
    private  int newSize = 0;

       public GameField () {
        setBackground(new Color(191, 216, 224, 255));
//компоненты


        JButton start = new JButton("NEW GAME");
//свойства
        start.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
        start.setBackground(Color.lightGray);
//соединение
           add(start);
//кнопка start
        start.addActionListener(e -> start());
        start.addKeyListener(new FieldKeyListener());
    }


    public void start() {
        firstApplePosition();
        initGame();
        addKeyListener(new FieldKeyListener());
    }

    public void firstApplePosition() {
        //только числа кратные 20
        appleX = (int) (2 + Math.random() * 15)*20;
        appleY = (int) (2 + Math.random() * 15)*20;
    }

    public void initGame() {
        timer = new Timer(200, this);
        timer.start();

    }

    public void move() {
        if (moveLeft) {
            snakeX = snakeX - 20;
        }
        if (moveUp){
            snakeY = snakeY - 20;
        }
        if (moveDown){
            snakeY = snakeY + 20;
        }
        if (moveRight){
            snakeX = snakeX + 20;
        }
    }

    public void stop() {
        JOptionPane.showMessageDialog(frame, "YOU ARE DEAD!");
        snakeX=40;
        snakeY=340;
        firstApplePosition();
    }

    public void mistake(){
        if (snakeX >=20 && snakeX<=360 && snakeY ==20){
        stop();
        }
        if (snakeX ==360 && snakeY>=20 && snakeY <=360){
            stop();
        }
        if (snakeX >=20 && snakeX<=360 && snakeY ==360){
            stop();
        }
        if (snakeX ==20 && snakeY>=20 && snakeY <=360){
            stop();
        }
        if (snakeX == appleX && snakeY == appleY){
            firstApplePosition();


        }

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new java.awt.Color(130, 199, 145, 255));
        g.fillRect(40, 40, 320, 320);
        g.setColor(new java.awt.Color(73, 58, 84, 255));
        g.fillRect(snakeX, snakeY, 20, 20);

        g.setColor(new java.awt.Color(159, 78, 222, 255));
        g.fillRect(20, 40, 20, 320);
        g.fillRect(360, 40, 20, 320);
        g.fillRect(40, 20, 320, 20);
        g.fillRect(40, 360, 320, 20);
        g.setColor(Color.RED);
        g.fillOval(appleX, appleY, 20, 20);
    }



    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        boolean go = true;
        if (go) {
            move();
            mistake();
            repaint();

        }

    }

    class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT ) {
                moveLeft = true;
                moveUp = false;
                moveDown = false;
            }
            if (key == KeyEvent.VK_RIGHT ) {
                moveUp = false;
                moveDown = false;
                moveRight = true;

            }
            if (key == KeyEvent.VK_UP ) {
                moveLeft = false;
                moveUp = true;
                moveRight = false;

            }
            if (key == KeyEvent.VK_DOWN) {
                moveLeft = false;
                moveDown = true;
                moveRight = false;
            }



        }
    }
}