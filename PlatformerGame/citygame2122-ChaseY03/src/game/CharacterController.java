package game;

import city.cs.engine.World;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class CharacterController implements KeyListener {

    private static final float WALKING_SPEED = 8;
    private Character character;
    private final GameView gameview;
    private final Game game;
    private final GameLevel level;
    //private GameView camera;
    //private Game world;

    //public CharacterController(Character c, GameView cam){
    public CharacterController(Character c, GameView gv, Game game, GameLevel level) {
        character = c;
        gameview = gv;
        this.game = game;
        this.level = level;
        //camera = cam;
        //this.world = world;
    }
    //KeyHandler

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // other key commands omitted
        if (code == KeyEvent.VK_W || code == KeyEvent.VK_SPACE) {
            character.jump(12);
        } else if (code == KeyEvent.VK_A) {
            character.startWalking(-WALKING_SPEED);
        } else if (code == KeyEvent.VK_D) {
            character.startWalking(WALKING_SPEED);
        } else if (code == KeyEvent.VK_A && code == KeyEvent.VK_SHIFT) {
            character.startWalking((-WALKING_SPEED) * 2);
        } else if (code == KeyEvent.VK_D && code == KeyEvent.VK_SHIFT) {
            character.startWalking((WALKING_SPEED) * 2);
        }

        // Interact
        else if (code == KeyEvent.VK_E) {

        }
    }
/*
            else if (code == KeyEvent.VK_S) {
                character.crouch();
            }

        // shoot - BROKEN // No collision
            else if (code == KeyEvent.VK_Q) {
                this.world = GameWorld;
                Shoot bullet = new Shoot(world, GameWorld.getCh());
        }
    */

        @Override
        public void keyReleased (KeyEvent e){
            int code = e.getKeyCode();
            if (code == KeyEvent.VK_W) {
                character.stopWalking();
            } else if (code == KeyEvent.VK_S) {
                character.stopWalking();
            } else if (code == KeyEvent.VK_A) {
                character.stopWalking();
            } else if (code == KeyEvent.VK_D) {
                character.stopWalking();
            }
        }

        @Override
        public void keyTyped (KeyEvent e){
        }

        public void updateCharacter (Character character){
            this.character = character;

        }
    }