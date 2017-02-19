package be.cegeka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class Snake implements ActionListener, KeyListener {
    public JFrame frame;
    public RenderPanel renderPanel = new RenderPanel();
    static Snake snake;
    public Timer timer = new Timer(10, this);
    public ArrayList<Point> snakeParts = new ArrayList<Point>();
    public static final int up = 0, down = 1, left = 2, right = 3, scale = 10;
    public int ticks = 0, direction = down, score, tailLength = 10;
    public Point head, cherry;
    public Random random;
    public Dimension dim;
    public boolean over = false, pause = false;

    public static void main(String[] args) {
        snake = new Snake();
    }

    public Snake() {
        setUpFrame();
        setFrameCenterScreen();
    }

    public void setFrameCenterScreen() {
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
    }

    public void setUpFrame() {
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame = new JFrame("Snake");
        frame.setVisible(true);
        frame.setSize(805, 700);
        frame.setResizable(false);
        frame.add(renderPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(this);
        startGame();
    }

    public void startGame() {
        snakeParts.clear();
        pause = false;
        over = false;
        score = 0;
        tailLength = 0;
        direction = down;
        head = new Point(0, 0);
        random = new Random();
        cherry = new Point(random.nextInt(79), random.nextInt(66));
//        for (int i = 0; i < tailLength; i++) {
//            snakeParts.add((new Point(head.x, head.y)));
//        }
        timer.start();
    }


    public void actionPerformed(ActionEvent actionEvent) {
        renderPanel.repaint();
        ticks++;

        if (ticks % 5 == 0 && head != null && !over && !pause) {
            snakeParts.add(new Point(head.x, head.y));
            if (direction == up) {
                if (head.y - 1 >= 0 && noTailAt(head.x , head.y -1 )) {
                    head = new Point(head.x, head.y - 1);
                } else {
                    over = true;
                }
            } else if (direction == down) {
                if (head.y + 1 <67 && noTailAt(head.x , head.y + 1)) {
                    head = new Point(head.x, head.y + 1);
                } else {
                    over = true;
                }
            } else if (direction == left) {
                if (head.x - 1 >= 0 && noTailAt(head.x - 1 , head.y)) {
                    head = new Point(head.x - 1, head.y);
                } else {
                    over = true;
                }
            } else if (direction == right) {
                if (head.x + 1 < 80 && noTailAt(head.x + 1 , head.y))
                    head = new Point(head.x + 1, head.y);
            } else {
                over = true;
            }
            if (snakeParts.size() > tailLength){
                snakeParts.remove(0);
            }

            if (cherry != null) {
                if (head.equals(cherry)) {
                    score += 10;
                    tailLength++;
                    cherry.setLocation(random.nextInt(79), random.nextInt(66));
                }
            }
        }

    }

    private boolean noTailAt(int x, int y) {
        for (Point point : snakeParts) {
            if (point.equals(new Point(x, y))){
                return false;
            }
        }
        return true;
    }

    public void keyTyped(KeyEvent keyEvent) {

    }

    public void keyPressed(KeyEvent keyEvent) {
        int i = keyEvent.getKeyCode();
        if (i == KeyEvent.VK_LEFT && direction != right) {
            direction = left;
        }
        if (i == KeyEvent.VK_RIGHT && direction != left) {
            direction = right;
        }
        if (i == KeyEvent.VK_DOWN && direction != up) {
            direction = down;
        }
        if (i == KeyEvent.VK_UP && direction != down) {
            direction = up;
        }
        if (i == KeyEvent.VK_F5 && over) {
            startGame();
        }
        if (i == KeyEvent.VK_SPACE && !over) {
            pause = !pause;
        }
    }

    public void keyReleased(KeyEvent keyEvent) {

    }
}

