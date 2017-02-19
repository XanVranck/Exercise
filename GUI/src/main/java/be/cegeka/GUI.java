package be.cegeka;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener{
    JFrame frame = new JFrame();
    JButton button = new JButton("Click me!");

    public static void main (String[] args) {
        GUI gui = new GUI();
        gui.go();
    }

    private void go() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(button);

        button.addActionListener(this);

        frame.setSize(300,150);
        frame.setVisible(true);
    }

    public void changeTextButton(){
        button.setText("I've been clicked!");
    }

    public void actionPerformed(ActionEvent actionEvent) {
        changeTextButton();
    }
}
