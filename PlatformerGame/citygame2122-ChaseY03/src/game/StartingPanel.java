package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartingPanel {
    private final Game game;
    private JPanel mainPanel;
    private JButton startButton;
    private JButton keybindsButton;
    private JButton quitButton;
    private JLabel bgImg;
    private JPanel imagePanel;
    private JLabel bgImage;
    private final ImageIcon startingBG;

    public StartingPanel(Game g){
        super();
        this.game = g;
        //g.frame.setPreferredSize(new Dimension(500,500));
        startingBG = new ImageIcon("data/startingImg.png");
        //mainPanel.setBackground(Color.blue);
        bgImg.setIcon(startingBG);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.gameStart();
            }
        });
        keybindsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            game.keybindsGUI();
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Exiting");
                System.exit(0);
            }
        });
    }
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
