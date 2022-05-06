package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class is dedicated to listening for the key event that will pause the game for the player.
 * It will check if the escape key has been pressed and if it has been pressed it will pause the game and load the paused
 * menu GUI, if that menu has already been loaded and the game state is set to paused it will reset and start the game.
 */


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
