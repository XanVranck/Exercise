package be.cegeka;

import javax.swing.*;
import java.awt.*;

public class RenderPanel extends JPanel{
    public static Color green = new Color(1666073);


    @Override
    protected void paintBorder(Graphics graphics) {
        //Adjusting the backgroundcolor of the whole frame (800 op 700)
        super.paintBorder(graphics);
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0,800,700);
        Snake snake = Snake.snake;
        graphics.setColor(Color.BLUE);
        for(Point point : snake.snakeParts){
            graphics.fillRect(point.x * Snake.scale, point.y * Snake.scale, Snake.scale, Snake.scale);
        }
        graphics.fillRect(snake.head.x * Snake.scale, snake.head.y * Snake.scale, Snake.scale, Snake.scale);
        graphics.setColor(Color.RED);
        graphics.fillRect(snake.cherry.x * Snake.scale, snake.cherry.y * Snake.scale, Snake.scale, Snake.scale);
        String score = "score: " +snake.score + ", length: " + snake.tailLength;
        graphics.setColor(Color.WHITE);
        graphics.drawString(score, (int) getWidth() /2 - score.length() *2,  10);
    }
}
