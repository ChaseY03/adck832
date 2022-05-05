package game;

import city.cs.engine.SoundClip;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsPanel {
    private JPanel mainPanel;
    private JButton muteButton;
    private JButton backButton;
    private final Game game;


    public JPanel getMainPanel() {
        return mainPanel;
    }


    public SettingsPanel(Game game) {
        this.game = game;
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.mainGUI();
            }
        });
        muteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Stops all background music and sound effects
                if (game.soundMuted == 2){
                    //unmuted
                    game.soundMuted = 1;
                    game.bgMusic.loop();
                    System.out.println("Unmuted");
                }
                else{
                    //muted
                    game.soundMuted = 2;
                    game.bgMusic.stop();
                    System.out.println("Muted");
                }
            }
        });
    }
}
