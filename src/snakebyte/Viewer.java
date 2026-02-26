package snakebyte;

import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/******************************************************************
 * {@code @author:} A. Ford
 * TODO: Press the "Play" button on the Right to start the GUI.
 * This class creates a display frame for Snake Game graphics.
 ******************************************************************/
public class Viewer{
    public static final int WIDTH  = GamePanel.WIDTH;
    public static final int HEIGHT = GamePanel.HEIGHT;
    public static final int LEFT_X = 500;
    public static final int TOP_Y  = 100;

    public Viewer(){

        Color           bgColor         = Color.DARK_GRAY;
        Color           bottomColor     = Color.LIGHT_GRAY;
        JFrame          frame           = new JFrame("Snake Game");
        KeyController   keyController   = new KeyController();
        GamePanel       gamePanel       = new GamePanel(keyController);
        JPanel          topPanel        = new JPanel();
        JPanel          leftPanel       = new JPanel();
        JPanel          rightPanel      = new JPanel();

        gamePanel.addKeyListener(keyController);
        gamePanel.setFocusable(true);
        gamePanel.setFocusTraversalKeysEnabled(false);

        keyController.bottomPanel.add(gamePanel.gameButton, BorderLayout.EAST);

        topPanel.setBackground(bottomColor);
        leftPanel.setBackground(bottomColor);
        rightPanel.setBackground(bottomColor);

        frame.setBackground(bgColor);
        frame.setLayout(new BorderLayout());
        frame.add(gamePanel, BorderLayout.CENTER);
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(leftPanel, BorderLayout.EAST);
        frame.add(rightPanel, BorderLayout.WEST);
        frame.add(keyController.bottomPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocation(LEFT_X, TOP_Y);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        SwingUtilities.invokeLater(gamePanel::requestFocusInWindow);
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Viewer::new);
    }

}
