package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PausedController implements KeyListener {
    private Character character;
    private final GameView gameview;
    private final Game game;

    public PausedController(Character c, GameView gv, Game game){
        character = c;
        gameview = gv;
        this.game = game;
    }
    //KeyHandler
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // Pause

        if (code == KeyEvent.VK_ESCAPE){
            if (game.gameState == game.playState){
                game.gameState = game.pausedState;
                System.out.println("Paused");
                game.toggleGUI();
            }
            //else if(game.gameState == game.pausedState){
            else{
                game.gameState = game.playState;
                System.out.println("Resumed");
                game.toggleGUI();
                game.frame.remove(game.GUIsettings.getMainPanel());
                game.frame.pack();
            }
            game.gamePaused();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public void updateCharacter(Character character) {
        this.character = character;

    }

}
