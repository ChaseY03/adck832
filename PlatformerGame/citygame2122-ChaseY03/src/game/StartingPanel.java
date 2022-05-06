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

    /**
     * This is the start screen the player sees when they run this game, it includes the start game, keybind help,
     * and quit game key
     * @param g this is what the game variable is named, this helps the GUI load onto the right window.
     */
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
