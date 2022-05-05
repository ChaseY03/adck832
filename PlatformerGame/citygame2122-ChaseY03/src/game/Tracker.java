package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class Tracker implements StepListener {

    private final GameView view;
    private final Character character;
    //private Enemy[] enemyArray;
    private final boolean moving = false;

    public void preStep(StepEvent e) {}
    public void postStep(StepEvent e) {
        //FIX PLATFORM SCALE WITH CAMERA
        //System.out.println("poststep");
        //view.setCentre(character.getPosition());
        //view.setCentre(new Vec2(character.getPosition().x, -6f));
    }

    public Tracker(GameView view, Character ch) {
        this.view = view;
        this.character = ch;
    }


/*
    public Tracker(GameView view, Character character, Enemy enemyArray){
        this.view = view;
        this.character = character;
        //this.enemyArray = enemyArray;
    }
*/
    //public void
}
