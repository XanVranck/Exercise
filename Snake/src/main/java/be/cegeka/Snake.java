package be.cegeka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Snake implements ActionListener {
    public JFrame frame;
    public RenderPanel renderPanel = new RenderPanel();
    static Snake snake;
    public Timer timer = new Timer(10000, this);
    public ArrayList<Point> snakeParts = new ArrayList<Point>();
    public static final int up = 0, down = 1, left = 2, right = 3, scale = 10;
    public int ticks = 0, direction = down, score;
    public Point head, cherry;
    public Random random;
    public Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    public boolean over = false;

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
        frame = new JFrame("Snake");
        frame.setVisible(true);
        frame.setSize(800, 700);
        frame.add(renderPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        head = new Point(0, 0);
        random = new Random();
        cherry = new Point(dim.width / scale, dim.height / scale);
        timer.start();
    }

    public void actionPerformed(ActionEvent actionEvent) {
        renderPanel.repaint();
        ticks++;

        if (ticks % 10 == 0) {
            if (direction == up && head != null && !over) {
                if (head.y - 1 > 0) {
                    snakeParts.add(new Point(head.x, head.y - 1));
                } else {
                    over = true;
                }
            } else if (direction == down) {
                if (head.y + 1 < dim.height / scale) {
                    snakeParts.add(new Point(head.x, head.y + 1));
                } else {
                    over = true;
                }
            } else if (direction == left) {
                if (head.x - 1 > 0) {
                    snakeParts.add(new Point(head.x - 1, head.y));
                } else {
                    over = true;
                }
            } else if (direction == right) {
                if (head.x + 1 < dim.width / scale)
                    snakeParts.add(new Point(head.x + 1, head.y));
            } else {
                over = true;
            }snakeParts.remove(0);
            if (cherry != null) {
                if (head.equals(cherry)) {
                    score++;
                    cherry.setLocation(dim.width / scale, dim.height / scale);
                }
            }
        }

    }
}
}
