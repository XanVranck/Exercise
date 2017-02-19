package be.cegeka;

import javax.swing.*;
import java.awt.*;

public class RenderPanel extends JPanel{
    public static int curlColor = 0;
    public static Color green = new Color(1666073);


    @Override
    protected void paintBorder(Graphics graphics) {
        //Adjusting the backgroundcolor of the whole frame (800 op 700)
        super.paintBorder(graphics);
        graphics.setColor(green);
        graphics.fillRect(0,0,800,700);
        Snake snake = Snake.snake;
        curlColor++;
    }
}
