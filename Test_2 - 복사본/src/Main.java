package src;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {




    public static void main(String[] args){
        LoginFrame myFrame = new LoginFrame();
        myFrame.setPreferredSize(new Dimension(350, 200));
        myFrame.setLocation(500, 400);
        myFrame.pack();
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
