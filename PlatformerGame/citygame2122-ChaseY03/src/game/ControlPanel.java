package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ControlPanel {
    private JPanel mainPanel;
    private JButton quitButton;
    private JButton restartButton;
    private JButton settingsButton;
    private JButton saveButton;
    private final Game game;
    private final GameView view;
    private final GameLevel level;

    public ControlPanel(Game game, GameView view, GameLevel level){
        this.game = game;
        this.view = view;
        this.level = level;

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Exiting");
                System.exit(0);
            }
        });

        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Restarting");
                game.setLV(new Level1(game));
                game.setHp(5);
                game.setCreds(0);
                view.playTime = 0;
                game.frame.remove(game.GUImain.getMainPanel());
                game.setGuiOn(false);
                game.frame.pack();
                game.gameState = game.playState;
                game.updateWorld();
            }

        });

        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.settingsGUI();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Saving...");
                try {
                    GameSaverLoader.save("data/save.txt", level, game, view);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

}
