package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TutorialPanel {
    private JPanel mainPanel;
    private JButton backButton;
    private JLabel keybindsPlaceholder;
    private final ImageIcon keybindsImg;

    public TutorialPanel(Game game){
        keybindsImg = new ImageIcon("data/keybindsImg.png");
        keybindsPlaceholder.setIcon(keybindsImg);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            game.frame.remove(game.GUIhelp.getMainPanel());
            game.frame.add(game.GUIstart.getMainPanel());
            game.frame.pack();
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
